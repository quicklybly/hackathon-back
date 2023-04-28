package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cpf.back.entity.Competition;
import ru.cpf.back.entity.Sportsman;

import java.util.Optional;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    @Query("SELECT s FROM Competition s WHERE s.id =:id")
    Optional<Competition> findCompetitionById(Long id);
}
