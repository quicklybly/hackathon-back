package ru.cpf.back.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.cpf.back.dto.ErrorDto;
import ru.cpf.back.exception.AppException;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDto> handleAppException(AppException exception) {
        HttpStatus status = switch (exception.getCode()) {
            case USER_NOT_FOUND, COMPETITION_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case USER_UNAUTHORIZED -> HttpStatus.UNAUTHORIZED;
            case USERNAME_IS_TAKEN,
                    EMAIL_IS_TAKEN -> HttpStatus.CONFLICT;
            case SERVER_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
            case INVALID_VOTE_VALUE -> HttpStatus.BAD_REQUEST;
        };
        String code = exception.getCode().toString();
        String message = exception.getMessage();
        log.error(code, exception);
        return ResponseEntity
                .status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorDto.builder()
                        .code(code)
                        .message(message)
                        .build());
    }
}
