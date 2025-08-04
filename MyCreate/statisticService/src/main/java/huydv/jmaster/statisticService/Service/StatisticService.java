package huydv.jmaster.statisticService.Service;

import huydv.jmaster.statisticService.Model.StatisticDTO;

import java.util.List;

public interface StatisticService {
    void addStatistic(StatisticDTO statisticDTO);
    List<StatisticDTO> getStatistics();
}
