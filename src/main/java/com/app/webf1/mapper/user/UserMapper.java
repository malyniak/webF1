package com.app.webf1.mapper.user;

import com.app.webf1.mapper.BaseMapper;
import com.app.webf1.user.User;
import com.app.webf1.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends BaseMapper<User, UserDto> {
//    @Mapping(target = "id", ignore = true)
//    User toEntity(UserDto to);
}