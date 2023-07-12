package com.ajustadoati.user.domain.service;

import com.ajustadoati.user.domain.User;
import com.ajustadoati.user.domain.repository.UserRepository;

import java.util.List;

public class DomainUserService implements UserService {
    private final UserRepository userRepository;

    public DomainUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String saveUser(User user) {
        user = userRepository.save(user);
        return user.getId();
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAll();
    }

}
