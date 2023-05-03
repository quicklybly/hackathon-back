package ru.cpf.back.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cpf.back.controller.openapi.AuthApi;
import ru.cpf.back.dto.LoginRequest;
import ru.cpf.back.dto.LoginResponse;
import ru.cpf.back.dto.SportsmanDto;
import ru.cpf.back.service.AuthService;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController implements AuthApi {
    private final AuthService authService;

    @Override
    @PostMapping("/sportsman/register")
    public SportsmanDto registerSportsman(@Valid @RequestBody SportsmanDto user) {
        return authService.registerSportsman(user);
    }

    @Override
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
