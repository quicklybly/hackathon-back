package ru.cpf.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class SportsmanCompetitionKey implements Serializable {
    @NotNull
    @Column(name = "id_sportsman", nullable = false)
    private Long sportsmanId;

    @NotNull
    @Column(name = "id_competition", nullable = false)
    private Long competitionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsmanCompetitionKey that = (SportsmanCompetitionKey) o;
        return Objects.equals(sportsmanId, that.sportsmanId) && Objects.equals(competitionId, that.competitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportsmanId, competitionId);
    }
}
