package com.ajustadoati.user.service;

import com.ajustadoati.user.domain.User;
import com.ajustadoati.user.domain.repository.UserRepository;
import com.ajustadoati.user.domain.service.DomainUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class DomainUserServiceTest {
    private DomainUserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        userService = new DomainUserService(userRepository);
    }

    @Test
    void shouldSaveUser() {
        //given
        var id = "1234Test";
        var user = getUser();

        //when
        Mockito.when(userRepository.save(Mockito.any()))
            .thenReturn(User.builder()
                .id(id)
                .build());
        var result = userService.saveUser(user);

        //then
        Assertions.assertEquals(id, result);
    }

    @Test
    void shouldDeleteUser() {
        //given
        var user = getUser();
        userService = mock(DomainUserService.class);
        when(userRepository.save(any())).thenReturn(user);

        //when
        userService.deleteUser(user.getId());

        //then
        verify(userService, times(1)).deleteUser(user.getId());
        assertThat(userService.getUsers()).isEmpty();
    }

    @Test
    void shouldGetListUser() {
        //given
        final var user = getUser();

        //when
        when(userRepository.getAll()).thenReturn(List.of(user));
        var result = userRepository.getAll();

        //then
        Assertions.assertEquals(user.getName(), result.get(0)
            .getName());
    }

    private User getUser() {
        return User.builder()
            .id("uuiddd1234")
            .name("Test-user")
            .email("email-user")
            .mobil("4252523")
            .build();
    }

}
