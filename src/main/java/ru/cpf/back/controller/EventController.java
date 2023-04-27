package ru.cpf.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cpf.back.controller.openapi.EventApi;

@RequiredArgsConstructor
@RequestMapping("/events")
@RestController
public class EventController implements EventApi {
}
