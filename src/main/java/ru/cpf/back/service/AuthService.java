package ru.cpf.back.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cpf.back.dto.LoginRequest;
import ru.cpf.back.dto.LoginResponse;
import ru.cpf.back.dto.SportsmanDto;
import ru.cpf.back.dto.UserDto;
import ru.cpf.back.entity.AppUser;
import ru.cpf.back.entity.enums.RoleEnum;
import ru.cpf.back.exception.AppException;
import ru.cpf.back.mapper.UserMapper;
import ru.cpf.back.repository.RoleRepository;
import ru.cpf.back.repository.UserRepository;
import ru.cpf.back.security.JwtService;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public SportsmanDto registerSportsman(SportsmanDto sportsmanDto) {
        if (userRepository.existsByUsername(sportsmanDto.getUsername())) {
            throw AppException.CODE.USERNAME_IS_TAKEN.get();
        }
        if (userRepository.existsByEmail(sportsmanDto.getEmail())) {
            throw AppException.CODE.EMAIL_IS_TAKEN.get();
        }

        var role = roleRepository.findByName(RoleEnum.ROLE_SPORTSMAN)
                .orElseThrow(() -> {
                    log.error("Дурак базу сломал. Где роли?");
                    return AppException.CODE.SERVER_ERROR.get();
                });
        var sportsman = userMapper.sportsmanDtoToEntity(sportsmanDto);
        var password = passwordEncoder.encode(sportsmanDto.getPassword());
        sportsman.setPassword(password);
        sportsman.setRole(role);
        sportsman = userRepository.save(sportsman);
        sportsmanDto = userMapper.sportsmanEntityToDto(sportsman);
        return sportsmanDto;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        AppUser user = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElseThrow(AppException.CODE.USER_NOT_FOUND::get);
        var jwt = jwtService.generateToken(user);
        return new LoginResponse(jwt);
    }
}
