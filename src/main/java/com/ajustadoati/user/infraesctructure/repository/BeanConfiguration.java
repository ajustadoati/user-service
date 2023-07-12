package com.ajustadoati.user.infraesctructure.repository;

import com.ajustadoati.user.UserApplication;
import com.ajustadoati.user.domain.repository.UserRepository;
import com.ajustadoati.user.domain.service.DomainUserService;
import com.ajustadoati.user.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = UserApplication.class)
public class BeanConfiguration {

    @Bean
    UserService userService(final UserRepository userRepository){
        return new DomainUserService(userRepository);
    }
}
