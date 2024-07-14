package com.app.webf1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number", unique = true, nullable = false)
    private Integer number;
    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;
}
