package ru.cpf.back.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
public class Admin extends AppUser {
}
