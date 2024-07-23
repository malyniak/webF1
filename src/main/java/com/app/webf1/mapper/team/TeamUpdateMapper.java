package com.app.webf1.mapper.team;

import com.app.webf1.dto.TeamUpdateDto;
import com.app.webf1.entity.Team;
import com.app.webf1.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamUpdateMapper extends BaseMapper<Team, TeamUpdateDto> {
//    @Mapping(target = "id", ignore = true)
//    Team updateFromTo(TeamUpdateDto teamUpdateDto, @MappingTarget Team entity);
}
