package com.shivam.qoura.controller;

import com.shivam.qoura.dto.Request.LikeReqDto;
import com.shivam.qoura.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    @Autowired
    LikeService likeService ;

    //TODO 2 : Complete end to end Api call
    @PostMapping("/{type}/{targetId}/likes")
    public ResponseEntity<?> like(@RequestBody LikeReqDto likeReqDto ,
                                  @PathVariable("type") String type,
                                  @PathVariable("targetId") Long targetId){

        String response = likeService.saveLike(likeReqDto , type , targetId);
        return null ;
    }
}
