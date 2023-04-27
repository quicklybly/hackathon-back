package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cpf.back.entity.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
