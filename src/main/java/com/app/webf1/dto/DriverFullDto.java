package com.app.webf1.dto;

import com.app.webf1.entity.DriverStatus;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
