package com.shivam.qoura.dto.Request;

import com.shivam.qoura.models.TargetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeReqDto {
    private  Long userId ;
    // these fields are path variable , so set it into service layer and don't force body to have this variable
//    private Long targetId ;
//    private TargetType type ; // Type of the target , for lower case have to wrote logic in enum of uppercase
}
