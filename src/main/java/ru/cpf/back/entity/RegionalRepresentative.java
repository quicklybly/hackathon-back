package ru.cpf.back.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("regional_representative")
@Entity
public class RegionalRepresentative extends AppUser {
}
