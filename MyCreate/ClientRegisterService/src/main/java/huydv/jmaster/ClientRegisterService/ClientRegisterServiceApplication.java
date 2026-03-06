package huydv.jmaster.ClientRegisterService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientRegisterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRegisterServiceApplication.class, args);
	}

}
