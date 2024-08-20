package com.app.webf1.mapper.car;

import com.app.webf1.dto.CarFullDto;
import com.app.webf1.entity.Car;
import com.app.webf1.mapper.BaseMapper;
import com.app.webf1.mapper.team.TeamMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = TeamMapper.class)
public interface CarMapper extends BaseMapper<Car, CarFullDto> {
    @Mapping(source = "team", target = "teamFullDto")
    CarFullDto toTo(Car car);

}
