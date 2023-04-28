package ru.cpf.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cpf.back.controller.openapi.EventApi;
import ru.cpf.back.dto.CompetitionDto;
import ru.cpf.back.dto.TagDto;
import ru.cpf.back.dto.TypeDto;
import ru.cpf.back.service.EventService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/events")
@RestController
public class EventController implements EventApi {
    private final EventService eventService;

    @Override
    @GetMapping("/tags")
    public List<TagDto> getTags() {
        return eventService.getTags();
    }

    @Override
    @GetMapping("/")
    public List<CompetitionDto> getCompetitions() {
        return eventService.getCompetitions();
    }

    @Override
    @GetMapping("/types")
    public List<TypeDto> getTypes() {
        return eventService.getTypes();
    }
}
