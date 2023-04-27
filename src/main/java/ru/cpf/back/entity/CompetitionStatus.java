package ru.cpf.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;
import ru.cpf.back.entity.enums.CompetitionStatusEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "status")
@Entity
public class CompetitionStatus {
    @NotNull
    @Id
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(name)", write = "LOWER(?)")
    @Column(name = "name", nullable = false)
    private CompetitionStatusEnum name;

    @NotNull
    @Column(name = "display_name", nullable = false)
    private String displayName;
}
