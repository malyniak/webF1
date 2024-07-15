package com.app.webf1.mapper;

import com.app.webf1.dto.DriverUpdateDto;
import com.app.webf1.entity.Driver;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DriverUpdateMapper extends BaseMapper<Driver, DriverUpdateDto> {
    Driver updateFromTo(DriverUpdateDto dto, @MappingTarget Driver entity);
}
