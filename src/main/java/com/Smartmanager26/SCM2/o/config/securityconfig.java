package com.Smartmanager26.SCM2.o.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Smartmanager26.SCM2.o.services.impl.SecurityCustomerDetailsService;

@Configuration
public class securityconfig {

    private final SecurityCustomerDetailsService securityCustomerDetailsService;

    // Constructor-based injection for SecurityCustomerDetailsService
    public securityconfig(SecurityCustomerDetailsService securityCustomerDetailsService) {
        this.securityCustomerDetailsService = securityCustomerDetailsService;
    }
    @Autowired
    private OAuthenticationSuccessHandler handler;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(securityCustomerDetailsService); // Injected UserDetailsService
        daoProvider.setPasswordEncoder(passwordboy());
        return daoProvider;
    }

    @Bean
    public PasswordEncoder passwordboy(){
        return new BCryptPasswordEncoder();
    }
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        //configuration
        httpSecurity.authorizeHttpRequests(authorize->{
            //authorize.requestMatchers("/homes","/register").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });
        httpSecurity.formLogin(formLogin ->{
            formLogin.loginPage("/login")
            .loginProcessingUrl("/authenticate")
            .successForwardUrl("/user/dashbord")
            // .failureForwardUrl("/login?error=true")
            .usernameParameter("email")
            .passwordParameter("password");
        });
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.logout(logoutForm->{
            logoutForm.logoutUrl("/logut-man");
            logoutForm.logoutSuccessUrl("/login?logout=true");
        });
        //oauth configuration
        httpSecurity.oauth2Login(outh ->{
            outh.loginPage("/login");
            outh.successHandler(handler);
        });
        
        
        return httpSecurity.build();

    }
}
