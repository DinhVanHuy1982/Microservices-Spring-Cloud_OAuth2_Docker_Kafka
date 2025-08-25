package huydv.jmaster.accountservice.Controller;

import huydv.jmaster.accountservice.Client.NotificationService;
import huydv.jmaster.accountservice.Client.StatisticService;
import huydv.jmaster.accountservice.Model.AccountDTO;
import huydv.jmaster.accountservice.Model.MessageDTO;
import huydv.jmaster.accountservice.Model.StatisticDTO;
import huydv.jmaster.accountservice.Service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping()
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;

    @Autowired
    private StatisticService statisticService;
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/account")
    @Transactional
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        logger.info("Create Account...");
        accountService.add(accountDTO);
        Date date = new Date();
        statisticService.addStatistic(new StatisticDTO("Call from account\nAccount "+accountDTO.getName()+" was created at "+date, date));
        notificationService.sendNotification(new MessageDTO(accountDTO.getEmail(), accountDTO.getName(), "Created account success", "Account was created successfully"));
        logger.info("Account Created");
        return accountDTO;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccounts() {
        logger.info("Get All Accounts...");
        return accountService.getAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable(name = "id") Long id) {
        return Optional.of(new ResponseEntity<AccountDTO>(accountService.getOne(id), HttpStatus.OK))
                .orElse(new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        accountService.delete(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        accountService.update(accountDTO);
    }
}
