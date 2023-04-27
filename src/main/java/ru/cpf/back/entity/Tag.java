package ru.cpf.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tag {
    @NotNull
    @Id
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;
}
