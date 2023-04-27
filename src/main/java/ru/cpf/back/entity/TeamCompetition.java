package ru.cpf.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "team_competition")
@Entity
public class TeamCompetition {
    @NotNull
    @EmbeddedId
    private TeamCompetitionKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("teamId")
    @JoinColumn(name = "id_team", nullable = false)
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("competitionId")
    @JoinColumn(name = "id_competition", nullable = false)
    private Competition competition;

    @Positive
    private Integer place;
}
