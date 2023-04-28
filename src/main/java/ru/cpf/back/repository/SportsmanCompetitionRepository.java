package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cpf.back.entity.SportsmanCompetition;

public interface SportsmanCompetitionRepository extends JpaRepository<SportsmanCompetition, Long> {
    @Query("SELECT SUM(vote) FROM SportsmanCompetition WHERE competition.id = :id")
    Long getSumVotesByCompetitionId(Long id);
}
