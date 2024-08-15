package com.app.webf1.mapper.driver;

import com.app.webf1.dto.DriverFullDto;
import com.app.webf1.entity.Driver;
import com.app.webf1.mapper.BaseMapper;
import com.app.webf1.mapper.car.CarMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CarMapper.class)
public interface DriverMapper extends BaseMapper<Driver, DriverFullDto> {
   @Mapping(source = "car", target = "carFullDto")
    DriverFullDto toTo(Driver driver);
}