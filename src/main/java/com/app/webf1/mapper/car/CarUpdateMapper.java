package com.app.webf1.mapper.car;

import com.app.webf1.dto.CarUpdateDto;
import com.app.webf1.entity.Car;
import com.app.webf1.mapper.BaseMapper;
import com.app.webf1.mapper.team.TeamMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = TeamMapper.class)
public interface CarUpdateMapper extends BaseMapper<Car, CarUpdateDto> {
//    @Mapping(target = "id", ignore = true)
    Car updateFromTo(CarUpdateDto carUpdateDto, @MappingTarget Car entity);
}
