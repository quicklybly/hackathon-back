package ru.cpf.back.controller.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.cpf.back.dto.CompetitionDto;
import ru.cpf.back.dto.TagDto;
import ru.cpf.back.dto.TypeDto;
import ru.cpf.back.entity.Competition;

import java.util.List;

@Tag(name = "Event API", description = "API для взаимодействия с событиями")
public interface EventApi {
    @Operation(summary = "Get all tags")
    List<TagDto> getTags();

    @Operation(summary = "Get all competition")
    List<CompetitionDto> getCompetitions();

    @Operation(summary = "Get all competitions types")
    List<TypeDto> getTypes();
}
