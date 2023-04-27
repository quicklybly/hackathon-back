package ru.cpf.back.mapper;

import org.mapstruct.Mapper;
import ru.cpf.back.dto.TagDto;
import ru.cpf.back.dto.TypeDto;
import ru.cpf.back.entity.CompetitionType;
import ru.cpf.back.entity.Tag;

@Mapper(componentModel = "spring")
public interface CompetitionTypeMapper {
    CompetitionType dtoToEntity(TypeDto type);

    TypeDto entityToDto(CompetitionType type);
}