package ru.cpf.back.controller.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.cpf.back.dto.LoginRequest;
import ru.cpf.back.dto.LoginResponse;
import ru.cpf.back.dto.SportsmanDto;


@Tag(name = "Auth API", description = "API для регистрации и авторизации")
public interface AuthApi {
    @Operation(summary = "Register user")
    SportsmanDto registerSportsman(SportsmanDto dto);

    @Operation(summary = "Login user")
    LoginResponse login(LoginRequest loginRequest);
}
