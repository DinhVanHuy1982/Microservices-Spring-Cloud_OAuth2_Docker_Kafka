package huydv.jmaster.AuthService.Service.Impl;

import huydv.jmaster.AuthService.Entity.Account;
import huydv.jmaster.AuthService.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        account.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role));
//        });
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
