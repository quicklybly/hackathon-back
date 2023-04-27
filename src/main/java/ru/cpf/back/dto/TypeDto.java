package ru.cpf.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TypeDto {
    private long id;
    private String name;
    private String display_name;
}
