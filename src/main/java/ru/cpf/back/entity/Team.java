package ru.cpf.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Team {
    @NotNull
    @Id
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "sportsman_team",
            joinColumns = {@JoinColumn(name = "id_team")},
            inverseJoinColumns = {@JoinColumn(name = "id_sportsman")}
    )
    private List<Sportsman> participants;

    @OneToMany(mappedBy = "team")
    private List<TeamCompetition> competitions = new ArrayList<>();
}
