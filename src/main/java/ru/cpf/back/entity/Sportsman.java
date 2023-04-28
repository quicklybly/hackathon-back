package ru.cpf.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("sportsman")
@Entity
public class Sportsman extends AppUser {
    private String name;

    private String surname;

    private String patronymic;

    private LocalDate birthday;

    @Column(unique = true)
    private String document;
}
