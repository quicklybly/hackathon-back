package ru.cpf.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cpf.back.dto.CompetitionDto;
import ru.cpf.back.dto.TagDto;
import ru.cpf.back.dto.TypeDto;
import ru.cpf.back.dto.VoteResponse;
import ru.cpf.back.entity.AppUser;
import ru.cpf.back.mapper.CompetitionMapper;
import ru.cpf.back.mapper.CompetitionTypeMapper;
import ru.cpf.back.mapper.TagMapper;
import ru.cpf.back.repository.CompetitionRepository;
import ru.cpf.back.repository.SportsmanCompetitionRepository;
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
    private final SportsmanCompetitionRepository sportsmanCompetitionRepository;
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
        List<CompetitionDto> competitionDtos = competitionRepository.findAll()
                .stream()
                .map(competitionMapper::entityToDto)
                .collect(Collectors.toList());
        for (CompetitionDto dto : competitionDtos) {
            Long competitionId = dto.getId();
            Long sumVotes = sportsmanCompetitionRepository.getSumVotesByCompetitionId(competitionId);
            sumVotes = sumVotes == null ? 0 : sumVotes;
            dto.setSumVotes(sumVotes);
        }
        return competitionDtos;
    }

    public List<TypeDto> getTypes() {
        return typeRepository.findAll()
                .stream()
                .map(competitionTypeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public VoteResponse getVote(Long id, AppUser user) {
        var sportsmanCompetition = sportsmanCompetitionRepository
                .findByCompetitionIdAndSportsmanId(id, user.getId());
        var vote = sportsmanCompetition.getVote();
        return new VoteResponse(vote);
    }
}
