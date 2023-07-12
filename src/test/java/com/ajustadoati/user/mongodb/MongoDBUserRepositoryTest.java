package com.ajustadoati.user.mongodb;

import com.ajustadoati.user.domain.User;
import com.ajustadoati.user.infraesctructure.repository.MongoDBUserRepository;
import com.ajustadoati.user.infraesctructure.repository.SpringDataMongoUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MongoDBUserRepositoryTest {

    private SpringDataMongoUserRepository dataMongoUserRepository;
    private MongoDBUserRepository userRepository;

    @BeforeEach
    void setup() {
        dataMongoUserRepository = mock(SpringDataMongoUserRepository.class);
        userRepository = new MongoDBUserRepository(dataMongoUserRepository);
    }

    @Test
    void shouldSaveUser_viaSpringDataUserRepository() {
        //given
        final var user = getUser();

        //when
        userRepository.save(user);

        //then
        verify(dataMongoUserRepository).save(user);
    }

    @Test
    void shouldDeleteUser_viaSpringDataUserRepository() {
        //given
        final var user = getUser();

        //when
        Mockito.when(userRepository.getAll()).thenReturn(List.of(user));
        userRepository.delete(user.getId());

        //then
        verify(dataMongoUserRepository).delete(user);
    }

    @Test
    void shouldGetListUser_viaSpringDataUserRepository() {
        //given
        final var user = getUser();

        //when
        Mockito.when(userRepository.getAll()).thenReturn(List.of(user));
        var result = userRepository.getAll();

        //then
        verify(dataMongoUserRepository).findAll();
        Assertions.assertEquals(user.getName(), result.get(0).getName());
    }

    private User getUser() {
        return User.builder().id(UUID.randomUUID().toString()).name("Test-name").mobil("4266231").email("email-test").build();
    }

}
