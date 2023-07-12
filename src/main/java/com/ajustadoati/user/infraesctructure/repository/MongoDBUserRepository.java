package com.ajustadoati.user.infraesctructure.repository;

import com.ajustadoati.user.domain.User;
import com.ajustadoati.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class MongoDBUserRepository implements UserRepository {
    private final SpringDataMongoUserRepository dataMongoUserRepository;

    @Autowired
    public MongoDBUserRepository(SpringDataMongoUserRepository dataMongoUserRepository){
        this.dataMongoUserRepository = dataMongoUserRepository;
    }

    @Override
    public User save(User user) {
        return dataMongoUserRepository.save(user);
    }

    @Override
    public void delete(String id) {
        var user = dataMongoUserRepository.findAll()
            .stream()
            .filter(it-> it.getId().equals(id))
            .findFirst();
        user.ifPresent(dataMongoUserRepository::delete);
    }

    @Override
    public List<User> getAll() {
        return dataMongoUserRepository.findAll();
    }

}
