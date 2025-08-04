package huydv.jmaster.statisticService.Model;

import lombok.Data;

import java.sql.Date;

@Data
public class StatisticDTO {
    private Long id;
    private String message;
    private Date createdDate;
}
