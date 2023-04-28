package ru.cpf.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cpf.back.dto.CompetitionDto;
import ru.cpf.back.dto.UserDto;
import ru.cpf.back.dto.VoteRequest;
import ru.cpf.back.entity.AppUser;
import ru.cpf.back.entity.SportsmanCompetition;
import ru.cpf.back.entity.enums.RoleEnum;
import ru.cpf.back.exception.AppException;
import ru.cpf.back.mapper.UserMapper;
import ru.cpf.back.repository.CompetitionRepository;
import ru.cpf.back.repository.SportsmanCompetitionRepository;
import ru.cpf.back.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final CompetitionRepository competitionRepository;
    private final SportsmanCompetitionRepository sportsmanCompetitionRepository;
    private final UserMapper userMapper;

    public UserDto getUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(AppException.CODE.USER_NOT_FOUND::get);
        return getSpecificUserDtoByBasicEntity(user);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToDto)
                .collect(Collectors.toList());
    }

    public UserDto getProfile(AppUser user) {
        return getSpecificUserDtoByBasicEntity(user);
    }

    private UserDto getSpecificUserDtoByBasicEntity(AppUser user) {
        var id = user.getId();
        switch (user.getRole().getName()) {
            case ROLE_SPORTSMAN -> {
                var sportsman = userRepository.findSportsmenById(id)
                        .orElseThrow(AppException.CODE.USER_NOT_FOUND::get);
                return userMapper.sportsmanEntityToDto(sportsman);
            }
            case ROLE_ADMIN, ROLE_PARTNER, ROLE_REGIONAL_REPRESENTATIVE -> {
                return userMapper.userEntityToDto(user);
            }
        }
        throw AppException.CODE.USER_NOT_FOUND.get();
    }

    public Long voteForCompetitionByCompetitionId(AppUser user, VoteRequest voteRequest) {
        var id = user.getId();
        switch(user.getRole().getName()) {
            case ROLE_SPORTSMAN -> {
                var sportsman = userRepository.findSportsmenById(id)
                        .orElseThrow(AppException.CODE.USER_NOT_FOUND::get);
                long competitionId = voteRequest.getCompetitionId();
                var competition = competitionRepository.findCompetitionById(competitionId)
                        .orElseThrow(AppException.CODE.COMPETITION_NOT_FOUND::get);
                int vote = voteRequest.getVote();
                if (vote < -1 || vote > 1) {
                    throw AppException.CODE.INVALID_VOTE_VALUE.get();
                }
                SportsmanCompetition sc = new SportsmanCompetition(
                        sportsman,
                        competition,
                        vote);
                sportsmanCompetitionRepository.save(sc);
                return sportsmanCompetitionRepository.getSumVotesByCompetitionId(competitionId);
            }
        }
        throw AppException.CODE.USER_NOT_FOUND.get();
    }
}
