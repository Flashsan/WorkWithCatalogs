package by.mkrs.testApp.security;

import by.mkrs.testApp.entity.User;
import by.mkrs.testApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
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

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/catalogWasteClassification").hasRole("USER")
                .requestMatchers("/", "/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .and()
                .build();
    }

   @NotNull
    public void addViewControllers(ViewControllerRegistry controllerRegistry) {
        controllerRegistry.addViewController("/").setViewName("home");
        controllerRegistry.addViewController("/login");
    }
}
