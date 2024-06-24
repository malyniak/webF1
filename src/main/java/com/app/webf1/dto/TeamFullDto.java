package com.app.webf1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TeamFullDto {
    private Integer id;

    private String name;

    private String boss;

    private String engine;
}
