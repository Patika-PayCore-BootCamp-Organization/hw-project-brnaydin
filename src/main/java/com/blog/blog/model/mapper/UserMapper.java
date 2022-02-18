package com.blog.blog.model.mapper;

import com.blog.blog.model.User;
import com.blog.blog.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(source = "type.code", target = "type")
    UserDto toDto(User entity);

    @Mapping(source = "type", target = "type.code")
    User toEntity(UserDto dto);
}
