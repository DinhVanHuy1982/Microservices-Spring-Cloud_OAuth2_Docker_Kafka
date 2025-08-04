package huydv.jmaster.accountservice.Client.Impl;

import huydv.jmaster.accountservice.Client.StatisticService;
import huydv.jmaster.accountservice.Model.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StatisticServiceImpl implements StatisticService {
    Logger logger = LoggerFactory.getLogger(StatisticServiceImpl.class);
    @Override
    public void addStatistic(StatisticDTO statisticDTO) {
        // fall back
        logger.error("addStatistic is Slow");
    }
}
