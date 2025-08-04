package huydv.jmaster.accountservice.Service;

import huydv.jmaster.accountservice.Model.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    void add(AccountDTO accountDTO);
    void update(AccountDTO accountDTO);
    void updatePassword(AccountDTO accountDTO);
    List<AccountDTO> getAll();
    AccountDTO getOne(Long id);
    void delete(Long id);
}
