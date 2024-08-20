package com.app.webf1;

import com.app.webf1.dto.*;
import com.app.webf1.entity.DriverStatus;

import java.time.LocalDate;

public class TestData {

    public static CarCreateDto carCreateDto() {
        return CarCreateDto.builder()
                .number(2222)
                .teamFullDto(team())
                .build();
    }

    public static CarUpdateDto carUpdateDto() {
        return CarUpdateDto.builder()
                .number(1)
                .build();
    }

    public static TeamFullDto team() {
        var teamFullDto = new TeamFullDto();
        teamFullDto.setId(1);
        teamFullDto.setBoss("Christian Horner");
        teamFullDto.setName("Oracle Red Bull Racing");
        teamFullDto.setEngine("Honda RBPT");
        return teamFullDto;
    }

    public static DriverUpdateDto driverUpdateDto() {
        var driverUpdateDto = new DriverUpdateDto();
        driverUpdateDto.setId(1);
        driverUpdateDto.setFirstname("updatedFirstname");
        driverUpdateDto.setLastname("testLastname");
        driverUpdateDto.setBirthdate(LocalDate.of(2000, 1, 1));
        driverUpdateDto.setDriverStatus(DriverStatus.INJURY);
        driverUpdateDto.setHeight(200);
        driverUpdateDto.setWeight(70);
        return driverUpdateDto;
    }
    public static TeamUpdateDto teamUpdateDto() {
        return TeamUpdateDto.builder()
                .boss("Christian Horner")
                .name("Oracle Red Bull Racing")
                .engine("Honda RBPT")
                .build();
    }
    public static TeamCreateDto teamCreateDto() {
        return TeamCreateDto.builder()
                .boss("test")
                .name("test")
                .engine("test")
                .build();
    }

}
