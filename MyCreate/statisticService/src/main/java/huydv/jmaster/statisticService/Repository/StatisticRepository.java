package huydv.jmaster.statisticService.Repository;

import huydv.jmaster.statisticService.Entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StatisticRepository extends JpaRepository<Statistic,Long> {
}
