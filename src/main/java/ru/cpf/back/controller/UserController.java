package ru.cpf.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cpf.back.controller.openapi.UserApi;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController implements UserApi {

}
