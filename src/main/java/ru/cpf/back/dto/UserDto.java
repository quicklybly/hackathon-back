package ru.cpf.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Date birtday;
    private int document;
    private long id;
    private String role;
    private String email;
    private String name;
    private String password;
    private String patronymic;
    private String surname;
    private String username;
}
