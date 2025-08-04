package huydv.jmaster.accountservice.Repository;

import huydv.jmaster.accountservice.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
