package huydv.jmaster.accountservice.Client;

import huydv.jmaster.accountservice.Client.Impl.NotificationServiceImpl;
import huydv.jmaster.accountservice.Model.AccountDTO;
import huydv.jmaster.accountservice.Model.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", fallback = NotificationServiceImpl.class)
public interface NotificationService {
    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}
