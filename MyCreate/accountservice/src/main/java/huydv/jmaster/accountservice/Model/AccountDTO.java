package huydv.jmaster.accountservice.Model;
import lombok.Data;

import java.util.Set;

@Data
public class AccountDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Set<String> roles;
}
