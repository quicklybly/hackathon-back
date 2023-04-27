package ru.cpf.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;
import ru.cpf.back.entity.enums.CompetitionTypeEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "type")
@Entity
public class CompetitionType {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(name)", write = "LOWER(?)")
    @Column(name = "name", nullable = false)
    private CompetitionTypeEnum name;

    @NotNull
    @Column(name = "display_name", nullable = false)
    private String displayName;
}
