package ru.cpf.back.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
public class Partner extends AppUser {
}

