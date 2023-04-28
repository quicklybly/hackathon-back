package ru.cpf.back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cpf.back.dto.SportsmanDto;
import ru.cpf.back.dto.UserDto;
import ru.cpf.back.entity.AppUser;
import ru.cpf.back.entity.Sportsman;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Sportsman sportsmanDtoToEntity(SportsmanDto dto);

    @Mapping(ignore = true, target = "password")
    SportsmanDto sportsmanEntityToDto(Sportsman entity);

    @Mapping(ignore = true, target = "password")
    UserDto userEntityToDto(AppUser entity);
}
