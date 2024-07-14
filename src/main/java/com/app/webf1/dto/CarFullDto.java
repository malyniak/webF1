package com.app.webf1.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarFullDto extends BaseDto {
    private int id;
    private int number;
    private TeamFullDto teamFullDto;
}
