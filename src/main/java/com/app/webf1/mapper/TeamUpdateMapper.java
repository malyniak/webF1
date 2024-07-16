package com.app.webf1.mapper;

import com.app.webf1.dto.TeamUpdateDto;
import com.app.webf1.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamUpdateMapper extends BaseMapper <Team, TeamUpdateDto> {
    @Mapping(target = "id", ignore = true)
    Team updateFromTo(TeamUpdateDto teamUpdateDto, @MappingTarget Team entity);
}
