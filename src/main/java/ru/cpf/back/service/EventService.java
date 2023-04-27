package ru.cpf.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cpf.back.dto.TagDto;
import ru.cpf.back.mapper.TagMapper;
import ru.cpf.back.repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EventService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public List<TagDto> getTags() {
        return tagRepository.findAll()
                .stream()
                .map(tagMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
