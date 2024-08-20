package com.app.webf1.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarCreateDto extends BaseDto {
    private int number;
    private TeamFullDto teamFullDto;
}
