package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String name;

    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_coach")//cambiar nombre de la llave foranea por defecto seria coach_id
    private Coach coach;

    @OneToMany(targetEntity = Player.class,fetch = FetchType.LAZY, mappedBy = "club")
    //mappedBy = "club" se mapea con el nombre del objecto de tipo Club en Player
    //para evitar que se cree una tabla intermedia como de muchos a muchos
    //le indicamos su mapeo de la llave foranea
    private List<Player> players;
    @ManyToOne(targetEntity = FootballAssociation.class)
    private FootballAssociation footballAssociation;
    @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
    //Personalizando tabla intermedia de la relacion
    @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competitions"))
    private List<FootballCompetition> footballCompetitions;
}
