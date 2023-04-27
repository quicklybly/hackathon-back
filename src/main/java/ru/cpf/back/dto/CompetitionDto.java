package ru.cpf.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.catalina.LifecycleState;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CompetitionDto {
    private Long id;
    private String title;
    private String description;
    private String link;
    private TypeDto type;
    private StatusDto status;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<TagDto> tags;
}
