package com.ajustadoati.user.application.rest;

import com.ajustadoati.user.application.mapper.UserMapper;
import com.ajustadoati.user.application.request.CreateUserRequest;
import com.ajustadoati.user.application.request.dto.UserDto;
import com.ajustadoati.user.application.response.CreateUserResponse;
import com.ajustadoati.user.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/info")
    public String getInfo() {
        return "Hello ";
    }

    @Operation(summary = "saveUser", description = "Operation to save user.", tags = "User")
    @ApiResponse(responseCode = "201", description = "Returns Created",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "User validations don't succeed ",
        content = @Content(schema = @Schema(implementation = String.class)))
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateUserResponse createUser(@RequestBody final CreateUserRequest createUserRequest) {
        final String id = userService.saveUser(userMapper.toUser(createUserRequest.getUserDto()));

        return new CreateUserResponse(id);

    }

    @Operation(summary = "deleteUser", description = "Operation to delete user.", tags = "User")
    @ApiResponse(responseCode = "201", description = "Returns Deleted",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "User validations don't succeed ",
        content = @Content(schema = @Schema(implementation = String.class)))
    @DeleteMapping(value = "/{userId}")
    void deleteUser(@PathVariable final String userId) {
        userService.deleteUser(userId);
    }

    @Operation(summary = "Get All Users", description = "Operation to get users.", tags = "User")
    @ApiResponse(responseCode = "200", description = "Returns list",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "User list empty ",
        content = @Content(schema = @Schema(implementation = String.class)))
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> getAll() {
        var users = userService.getUsers();

        return userMapper.toUserDtoList(users);
    }

}
