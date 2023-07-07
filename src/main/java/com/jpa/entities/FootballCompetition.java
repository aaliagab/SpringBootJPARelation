package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FootballCompetition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "VARCHAR(300)")
    private String name;
    @Column(name = "quantity_price")
    private Integer quantityPrice;
    @Column(name = "start_date", columnDefinition = "DATE")//columnDefinition = "DATE" tipo de datos en la tabla
    private LocalDate startDate;
    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;
    //Quitamos este MamyToMany porque basta con el que se tiene en la clase Club
    //de lo contrario se crean dos tablas intermedias
    //@ManyToMany(targetEntity = Club.class, fetch = FetchType.LAZY)
    //private List<Club> clubs;
}
