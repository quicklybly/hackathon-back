package ru.cpf.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorValue("sportsman")
@Entity
public class Sportsman extends AppUser {
    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String patronymic;

    private LocalDate birthday;

    @NotNull
    @Column(unique = true)
    private Integer document;
}
