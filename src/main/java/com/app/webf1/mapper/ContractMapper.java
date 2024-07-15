package com.app.webf1.mapper;

import com.app.webf1.dto.ContractFullDto;
import com.app.webf1.entity.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {TeamMapper.class, DriverMapper.class})
public interface ContractMapper extends BaseMapper<Contract, ContractFullDto> {
}
