package ru.cpf.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDto {
    private long id;
    private String title;
    private String place;
    private TypeDto type;
    private StatusDto status;
    private Date date_start;
    private Date date_end;
    private List<TagDto> tags;
    private String description;
    private String link;
}
