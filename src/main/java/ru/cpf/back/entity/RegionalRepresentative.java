package ru.cpf.back.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@DiscriminatorValue("regional_representative")
@Entity
public class RegionalRepresentative extends AppUser {
}
