package com.app.webf1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarCreateDto extends BaseDto {
    private int number;
    private TeamFullDto teamFullDto;
}
