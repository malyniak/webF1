package com.app.webf1.mapper;

import com.app.webf1.dto.DriverCreateDto;
import com.app.webf1.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CarCreateMapper.class)
public interface DriverCreateMapper extends BaseMapper<Driver, DriverCreateDto> {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "carCreateDto",  target = "car")
    Driver toEntity (DriverCreateDto driverCreateDto);
}