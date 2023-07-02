package by.mkrs.testApp.security;

import by.mkrs.testApp.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig  {

@Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

    @Bean
    public UserDetailsService users() {
        UserDetails buzz = User.builder()
                .username("buzz")
                .password(passwordEncoder().encode("password"))
                .build();

        UserDetails woody = User.builder()
                .username("woody")
                .password(passwordEncoder().encode("password"))
                .build();

        List<UserDetails> userList = new ArrayList<>();
        userList.add(buzz);
        userList.add(woody);

        return new InMemoryUserDetailsManager(userList);
    }
}
