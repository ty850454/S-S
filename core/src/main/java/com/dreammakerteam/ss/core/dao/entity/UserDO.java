package com.dreammakerteam.ss.core.dao.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 用户
 *
 * @author xy
 */
@Getter
@Setter
@ToString
@Entity
public class UserDO extends BaseDO {

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '微信用户id'")
    private String openid;


}
