package huydv.jmaster.GatewayService;

import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(GatewayServiceApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(GatewayServiceApplication.class, args);
		Environment env = configurableApplicationContext.getEnvironment();
		logApplicationStartup(env);
	}
	private static void logApplicationStartup(Environment env) {
		String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store")).map(key -> "https").orElse("http");
		String serverPort = env.getProperty("server.port");
		String contextPath = Optional
				.ofNullable(env.getProperty("server.servlet.context-path"))
				.filter(StringUtils::isNotBlank)
				.orElse("/");
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info(
				"\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}{}\n\t" +
						"External: \t{}://{}:{}{}\n\t" +
						"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles()
		);
	}

	@Bean
	public RouteLocator customRoutesLocator(RouteLocatorBuilder builder, LoggingGatewayFilterFactory loggingFactory) {
		return builder.routes()
				.route("user-route", r -> r.path("/user/**")
						.filters(f->f.stripPrefix(1)
								.filter(loggingFactory.apply(new LoggingGatewayFilterFactory.Config()))
								.circuitBreaker(c -> c.setName("CircuitBreaker").getFallbackUri()))
						.uri("lb://account-service")
				)
				.route("report-route", r -> r.path("/report/**")
						.filters(f->f.stripPrefix(1))
						.uri("lb://statistic-service")
				)
				.route("notification-route", r -> r.path("/notification/**")
						.filters(f->f.stripPrefix(1))
						.uri("lb://notification-service")
				)
				.route("client-register-route", r -> r.path("/client-register/**")
						.filters(f->f.stripPrefix(1))
						.uri("lb://client-register-service")
				)
				// swagger ui
				.route("openapi", r -> r.path("/v3/api-docs/**")
						.filters(f->f.rewritePath("/v3/api-docs/(?<service>.*)", "/${service}/v3/api-docs"))
						.uri("lb://gateway-service")
				)
				.build();
	}
}
