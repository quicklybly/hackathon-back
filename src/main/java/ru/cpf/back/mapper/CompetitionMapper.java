package ru.cpf.back.mapper;

import org.mapstruct.Mapper;
import ru.cpf.back.dto.CompetitionDto;
import ru.cpf.back.entity.Competition;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionDto entityToDto(Competition competition);
}
