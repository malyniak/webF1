package com.app.webf1.entity;

import com.app.webf1.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "driver")
public class Driver extends Audit<Integer> {
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
    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;
    @OneToOne
    @JoinColumn(name = "car_number", unique = true, referencedColumnName = "number")
    private Car car;
}
