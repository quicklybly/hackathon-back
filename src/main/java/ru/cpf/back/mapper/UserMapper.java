package ru.cpf.back.mapper;

import org.mapstruct.Mapper;
import ru.cpf.back.dto.SportsmanDto;
import ru.cpf.back.dto.UserDto;
import ru.cpf.back.entity.AppUser;
import ru.cpf.back.entity.Sportsman;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Sportsman sportsmanDtoToEntity(SportsmanDto dto);

    SportsmanDto sportsmanEntityToDto(Sportsman entity);

    UserDto userEntityToDto(AppUser entity);
}
