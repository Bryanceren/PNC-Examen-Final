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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationService authenticationService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
<<<<<<< HEAD
                .antMatchers("/css/**", "/js/**", "/img/**", "/vendor/**").permitAll()
                .antMatchers("/").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
=======
            .antMatchers( "/register", "/css/**", "/js/**", "/img/**", "/vendor/**").permitAll()
            .antMatchers("/").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
>>>>>>> refs/remotes/origin/master
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout().permitAll();
        http.cors().and().csrf().disable();

    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
        PasswordEncoder encoder = passwordEncoder();

//        User.UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
//
//        builder.inMemoryAuthentication()
//            .withUser(users.username("admin").password("secret").roles("ADMIN"))
//            .withUser(users.username("coordinador").password("secret").roles("USER"));

<<<<<<< HEAD
        builder.inMemoryAuthentication()
                .withUser(users.username("admin").password("secret").roles("ADMIN"))
                .withUser(users.username("coordinador").password("secret").roles("USER"));

        //builder.userDetailsService(authenticationService).passwordEncoder(encoder);
=======
        builder.userDetailsService(authenticationService).passwordEncoder(encoder);
>>>>>>> refs/remotes/origin/master
    }


}
