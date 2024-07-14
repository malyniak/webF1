package com.app.webf1.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamFullDto {
    private Integer id;
    private String name;
    private String boss;
    private String engine;
}
