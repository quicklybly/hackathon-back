package ru.cpf.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sportsman_competition")
@Entity
public class SportsmanCompetition {
    @NotNull
    @EmbeddedId
    private SportsmanCompetitionKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sportsmanId")
    @JoinColumn(name = "id_sportsman")
    private Sportsman sportsman;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("competitionId")
    @JoinColumn(name = "id_competition")
    private Competition competition;
}
