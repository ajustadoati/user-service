package com.ajustadoati.user.mongodb;

import com.ajustadoati.user.domain.User;
import com.ajustadoati.user.domain.repository.UserRepository;
import com.ajustadoati.user.infraesctructure.repository.SpringDataMongoUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
@SpringBootTest
@TestPropertySource("classpath:layers-test.properties")
class MongoDBUserRepositoryIntTest {

    @Autowired
    private SpringDataMongoUserRepository dataMongoUserRepository;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void cleanUp() {
        dataMongoUserRepository.deleteAll();
    }

    @Test
    void shouldSaveUser() {
        //given
        final var user = getUser();

        //when
        var result = userRepository.save(user);

        //then
        assertEquals(user.getName(), result.getName());
    }

    private User getUser() {
        return User.builder()
            .id("123456781234567878548596")
            .name("Test-name")
            .email("Test-desc")
            .mobil("452525")
            .build();
    }

    @Test
    void shouldDeleteUser() {
        //given
        final var user = getUser();
        var result = userRepository.save(user);

        //when
        userRepository.delete(result.getId());

        //then
        assertThat(userRepository.getAll()).isEmpty();
    }

    @Test
    void shouldGetListUser() {
        //given
        final var user = getUser();
        final var user2 = getUser();
        final var user3 = getUser();
        userRepository.save(user);
        user2.setId("123456781234567878548597");
        userRepository.save(user2);
        user3.setId("123456781234567878548598");
        userRepository.save(user3);

        //when
        var result = userRepository.getAll();

        //then
        assertEquals(3, result.size());
    }

}
