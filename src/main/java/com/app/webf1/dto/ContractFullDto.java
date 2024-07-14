package com.app.webf1.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractFullDto {
    private Long id;
    private Integer salary;
    private Integer lastYear;
    private DriverFullDto driver;
    private TeamFullDto teamFullDto;
}
