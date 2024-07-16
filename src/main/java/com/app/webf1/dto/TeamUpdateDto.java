package com.app.webf1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamUpdateDto {
    private String name;
    private String boss;
    private String engine;
}