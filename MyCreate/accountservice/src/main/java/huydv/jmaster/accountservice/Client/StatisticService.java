package huydv.jmaster.accountservice.Client;

import huydv.jmaster.accountservice.Client.Impl.StatisticServiceImpl;
import huydv.jmaster.accountservice.Model.StatisticDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-service", fallback = StatisticServiceImpl.class)
public interface StatisticService {
    @PostMapping("/statistic")
    public void addStatistic(@RequestBody StatisticDTO statisticDTO);
}
