package com.shivam.qoura.service;

import com.shivam.qoura.dto.Request.LikeReqDto;
import com.shivam.qoura.dto.Response.LikeResDto;
import com.shivam.qoura.mappers.LikeMapper;
import com.shivam.qoura.models.Like;
import com.shivam.qoura.repositories.LikeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeMapper likeMapper = Mappers.getMapper(LikeMapper.class);
    private final LikeRepository likeRepository ;

    public LikeService(LikeRepository likeRepository){
        this.likeRepository = likeRepository ;
    }

    //TODO 1: have to set data
    public String saveLike(LikeReqDto likeReqDto , String type , Long targetId){
        //dto to  like entity
        Like like = likeMapper.likeDtoToLike(likeReqDto);

        //save Entity
        Like saveLike = likeRepository.save(like);

        return "Like added successfully!" ;
    }
}
