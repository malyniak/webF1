package com.app.webf1.mapper.team;

import com.app.webf1.dto.TeamCreateDto;
import com.app.webf1.entity.Team;
import com.app.webf1.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamCreateMapper extends BaseMapper<Team, TeamCreateDto> {
}
