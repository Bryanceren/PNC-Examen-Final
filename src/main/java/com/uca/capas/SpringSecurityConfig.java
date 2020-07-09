package com.uca.capas;

import com.uca.capas.service.Authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    AuthenticationService authenticationService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            .antMatchers( "/register", "/crear-usuario", "/css/**", "/js/**", "/img/**", "/vendor/**").permitAll()
            .antMatchers("/").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            .and()
            .logout().permitAll();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception
    {
        PasswordEncoder encoder = passwordEncoder();

//        User.UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
//
//        builder.inMemoryAuthentication()
//            .withUser(users.username("admin").password("secret").roles("ADMIN"))
//            .withUser(users.username("coordinador").password("secret").roles("USER"));

        builder.userDetailsService(authenticationService).passwordEncoder(encoder);
    }


}
