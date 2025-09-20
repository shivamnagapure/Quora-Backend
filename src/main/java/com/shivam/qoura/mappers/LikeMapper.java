package com.shivam.qoura.mappers;

import com.shivam.qoura.dto.Request.LikeReqDto;
import com.shivam.qoura.models.Like;
import com.shivam.qoura.models.Topic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    Like likeDtoToLike(LikeReqDto likeReqDto) ;
}
