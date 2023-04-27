package ru.cpf.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "competition")
@Entity
public class Competition {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String title;

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;

    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;

    private String description;

    private String link;

    @OneToMany(mappedBy = "competition")
    private List<TeamCompetition> teams = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tag_competition",
            joinColumns = {@JoinColumn(name = "id_competition")},
            inverseJoinColumns = {@JoinColumn(name = "id_tag")}
    )
    private List<Tag> tags;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private CompetitionType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private CompetitionStatus status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private AppUser organizer;
}
