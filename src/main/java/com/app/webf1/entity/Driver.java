package com.app.webf1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    private LocalDate birthdate;
    @Column(name = "nationality", nullable = false)
    private String nationality;
    @Column(name = "height", nullable = false)
    private Integer height;
    @Column(name = "weight", nullable = false)
    private Integer weight;
    @Column(name = "driver_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private DriverStatus driverStatus;
    @OneToOne
    @JoinColumn(name = "car_id", unique = true)
    private Car car;
}
