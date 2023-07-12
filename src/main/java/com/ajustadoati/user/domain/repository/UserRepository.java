package com.ajustadoati.user.domain.repository;

import com.ajustadoati.user.domain.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    void delete(String id);

    List<User> getAll();
}
