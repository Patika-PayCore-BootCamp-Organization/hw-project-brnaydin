package com.blog.blog.model.mapper;

import com.blog.blog.model.Post;
import com.blog.blog.model.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostDto toDto(Post post);

    Post toEntity(PostDto dto);

}
