package com.app.webf1.mapper;

import com.app.webf1.dto.TeamFullDto;
import com.app.webf1.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper extends BaseMapper<Team, TeamFullDto> {

    Team toEntity(TeamFullDto teamFullDto);
}
