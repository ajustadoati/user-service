package com.ajustadoati.user.infraesctructure.repository;

import com.ajustadoati.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoUserRepository extends MongoRepository<User, UUID> {

}
