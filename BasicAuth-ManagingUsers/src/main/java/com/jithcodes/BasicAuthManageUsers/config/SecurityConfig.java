package com.jithcodes.BasicAuthManageUsers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/announcements","/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }



    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // Option 1
        // Using withDefaultPasswordEncoder()

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .authorities("admin")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("jithcodes")
                .password("password")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin, user);

        // Option 2
        // Using NoOpPasswordEncoder

        UserDetails admin = User
                .withUsername("admin")
                .password("password")
                .authorities("admin")
                .build();
        UserDetails user = User
                .withUsername("jithcodes")
                .password("password")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin, user);


    }
     */

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    /**
     * NoOpPasswordEncoder is not recommended
     * Used just for simplicity purpose
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
