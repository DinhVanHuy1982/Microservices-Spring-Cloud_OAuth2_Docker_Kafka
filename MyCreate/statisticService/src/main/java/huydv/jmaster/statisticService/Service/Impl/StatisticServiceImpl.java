package huydv.jmaster.statisticService.Service.Impl;

import huydv.jmaster.statisticService.Entity.Statistic;
import huydv.jmaster.statisticService.Model.StatisticDTO;
import huydv.jmaster.statisticService.Repository.StatisticRepository;
import huydv.jmaster.statisticService.Service.StatisticService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    StatisticRepository statisticRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addStatistic(StatisticDTO statisticDTO) {
        Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getStatistics() {
        List<Statistic> statisticList = statisticRepository.findAll();
        List<StatisticDTO> statisticDTOList = new ArrayList<>();

        statisticList.forEach(statistic -> {
            StatisticDTO statisticDTO = modelMapper.map(statistic, StatisticDTO.class);
            statisticDTOList.add(statisticDTO);
        });

        return statisticDTOList;
    }
}
