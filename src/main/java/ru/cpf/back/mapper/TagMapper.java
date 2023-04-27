package ru.cpf.back.mapper;

import org.mapstruct.Mapper;
import ru.cpf.back.dto.TagDto;
import ru.cpf.back.entity.Tag;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag dtoToEntity(TagDto tag);

    TagDto entityToDto(Tag tag);
}
