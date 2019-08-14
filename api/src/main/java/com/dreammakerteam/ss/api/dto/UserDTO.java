package com.dreammakerteam.ss.api.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 用户
 *
 * @author xy
 */
@Getter
@Setter
@ToString

public class UserDTO extends BaseDTO {

    private String openId;

    private String nickname;

    private String headPortrait;

    private String mobilePhoneNo;


}
