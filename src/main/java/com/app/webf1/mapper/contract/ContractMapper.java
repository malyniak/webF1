package com.app.webf1.mapper.contract;

import com.app.webf1.dto.ContractFullDto;
import com.app.webf1.entity.Contract;
import com.app.webf1.mapper.BaseMapper;
import com.app.webf1.mapper.driver.DriverMapper;
import com.app.webf1.mapper.team.TeamMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {TeamMapper.class, DriverMapper.class})
public interface ContractMapper extends BaseMapper<Contract, ContractFullDto> {
}
