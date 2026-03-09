package com.example.Redis.resdis.mapper;

import com.example.Redis.resdis.dao.entity.BlogEntity;
import com.example.Redis.resdis.dto.request.BlogRequestDto;
import com.example.Redis.resdis.dto.response.BlogResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogResponseDto entityToDto(BlogEntity e);
    BlogEntity dtoToEntity(BlogRequestDto d);
    List<BlogEntity> dtoToEntityList(List<BlogRequestDto> d);
    List<BlogResponseDto> entityToDtoList(List<BlogEntity> e);



}
