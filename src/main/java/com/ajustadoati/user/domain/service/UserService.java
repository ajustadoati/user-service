package com.ajustadoati.user.domain.service;

import com.ajustadoati.user.domain.User;

import java.util.List;

public interface UserService {
    String saveUser(User user);

    void deleteUser(String userId);

    List<User> getUsers();
}
