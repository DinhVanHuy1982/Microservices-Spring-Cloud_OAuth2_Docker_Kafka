package huydv.jmaster.accountservice.Client.Impl;

import huydv.jmaster.accountservice.Client.NotificationService;
import huydv.jmaster.accountservice.Model.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {

    Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
    @Override
    public void sendNotification(MessageDTO messageDTO) {
        logger.error("Send Notification Error or Slow");
    }
}
