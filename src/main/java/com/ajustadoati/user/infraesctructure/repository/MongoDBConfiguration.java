package com.ajustadoati.user.infraesctructure.repository;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoUserRepository.class)
public class MongoDBConfiguration {
}
