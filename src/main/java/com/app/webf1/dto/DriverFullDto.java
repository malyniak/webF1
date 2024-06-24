package com.app.webf1.dto;

import com.app.webf1.entity.Car;
import com.app.webf1.entity.DriverStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DriverFullDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String nationality;
    private Integer height;
    private Integer weight;
    private DriverStatus driverStatus;
    private CarFullDto carFullDto;
}
