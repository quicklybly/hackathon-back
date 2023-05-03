package ru.cpf.back.controller.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.cpf.back.dto.UserDto;

import java.util.List;

@Tag(name = "User API", description = "API для пользователей")
public interface UserApi {
    @Operation(summary = "Get user by id")
    UserDto getUser(Long id);

    @Operation(summary = "Get all users")
    List<UserDto> getAllUsers();
}
