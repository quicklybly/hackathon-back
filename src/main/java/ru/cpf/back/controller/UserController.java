package ru.cpf.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cpf.back.controller.openapi.UserApi;
import ru.cpf.back.dto.UserDto;
import ru.cpf.back.entity.AppUser;
import ru.cpf.back.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @Override
    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/profile")
    public UserDto getProfile(@AuthenticationPrincipal AppUser user) {
        return userService.getProfile(user);
    }
}
