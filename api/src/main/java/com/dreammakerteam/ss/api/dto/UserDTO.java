package com.dreammakerteam.ss.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {

    private String openId;

    private String nickname;

    private String headPortrait;

    private String mobilePhoneNo;


}
