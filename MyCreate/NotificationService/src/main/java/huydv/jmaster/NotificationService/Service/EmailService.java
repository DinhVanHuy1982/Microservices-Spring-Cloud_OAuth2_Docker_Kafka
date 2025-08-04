package huydv.jmaster.NotificationService.Service;

import huydv.jmaster.NotificationService.Model.MessageDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(MessageDTO messageDTO);
}
