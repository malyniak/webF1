package com.app.webf1.mapper.car;

import com.app.webf1.dto.CarCreateDto;
import com.app.webf1.entity.Car;
import com.app.webf1.mapper.BaseMapper;
import com.app.webf1.mapper.team.TeamCreateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = TeamCreateMapper.class)
public interface CarCreateMapper extends BaseMapper<Car, CarCreateDto> {
//    @Mapping(target = "id", ignore = true)
//    @Mapping(source = "teamFullDto", target = "team")
//    Car toEntity(CarCreateDto carCreateDto);
}
