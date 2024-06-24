package com.app.webf1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContractFullDto {
    private Long id;
    private Integer salary;
    private Integer lastYear;
    private DriverFullDto driver;
    private TeamFullDto team;
}
