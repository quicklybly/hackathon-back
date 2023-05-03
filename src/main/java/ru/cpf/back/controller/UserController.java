package ru.cpf.back.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.cpf.back.controller.openapi.UserApi;
import ru.cpf.back.dto.SportsmanDto;
import ru.cpf.back.dto.UserDto;
import ru.cpf.back.dto.VoteRequest;
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

    @Operation(summary = "Vote for competition")
    @PostMapping("/vote")
    public Long voteForCompetitionByCompetitionId(@AuthenticationPrincipal AppUser user,
                                                 @RequestBody VoteRequest voteRequest) {
        return userService.voteForCompetitionByCompetitionId(user, voteRequest);
    }

    @Operation(summary = "Get profile by Jwt")
    @GetMapping("/profile")
    public UserDto getProfile(@AuthenticationPrincipal AppUser user) {
        return userService.getProfile(user);
    }

    @Operation(summary = "Edit profile by Jwt")
    @PutMapping("/profile/sportsman")
    public UserDto editProfileSportsman(@AuthenticationPrincipal AppUser user,
                               @RequestBody SportsmanDto sportsmanDto) {
        return userService.editProfileSportsman(user, sportsmanDto);
    }
}
