package com.dreammakerteam.ss.core.dao.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author xy
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "wx_user", indexes = @Index(columnList="openId"))
@org.hibernate.annotations.Table(appliesTo = "wx_user", comment = "用户")
public class UserDO extends BaseDO {

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '微信用户id'")
    private String openId;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '用户昵称'")
    private String nickname;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '头像'")
    private String headPortrait;

    @Column(columnDefinition = "varchar(255) COMMENT '手机号'")
    private String mobilePhoneNo;


}
