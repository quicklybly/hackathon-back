package ru.cpf.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cpf.back.dto.CompetitionDto;
import ru.cpf.back.dto.TagDto;
import ru.cpf.back.dto.TypeDto;
import ru.cpf.back.entity.Competition;
import ru.cpf.back.mapper.CompetitionMapper;
import ru.cpf.back.mapper.CompetitionTypeMapper;
import ru.cpf.back.mapper.TagMapper;
import ru.cpf.back.repository.CompetitionRepository;
import ru.cpf.back.repository.TagRepository;
import ru.cpf.back.repository.TypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EventService {
    private final TagRepository tagRepository;
    private final CompetitionRepository competitionRepository;
    private final TypeRepository typeRepository;
    private final TagMapper tagMapper;
    private final CompetitionMapper competitionMapper;
    private final CompetitionTypeMapper competitionTypeMapper;

    public List<TagDto> getTags() {
        return tagRepository.findAll()
                .stream()
                .map(tagMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public List<CompetitionDto> getCompetitions() {
        return competitionRepository.findAll()
                .stream()
                .map(competitionMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public List<TypeDto> getTypes() {
        return typeRepository.findAll()
                .stream()
                .map(competitionTypeMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
