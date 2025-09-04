package huydv.jmaster.AuthService.Repository;

import huydv.jmaster.AuthService.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
