package com.app.webf1.mapper.team;

import com.app.webf1.dto.TeamFullDto;
import com.app.webf1.entity.Team;
import com.app.webf1.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper extends BaseMapper<Team, TeamFullDto> {
    TeamFullDto toTo(Team entity);
}
