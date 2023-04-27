package ru.cpf.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDto {
    private long id;
    private String name;
    private String display_name;
}
