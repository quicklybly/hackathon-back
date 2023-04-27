package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cpf.back.entity.CompetitionType;

public interface TypeRepository extends JpaRepository<CompetitionType, Long> {
}
