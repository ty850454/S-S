package com.dreammakerteam.ss.core.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户服务卡
 *
 * @author xy
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "wx_userService", indexes = @Index(columnList="userId"))
@org.hibernate.annotations.Table(appliesTo = "wx_userService", comment = "用户")
public class UserServiceDO extends BaseDO {

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '关联用户id'")
    private Long userId;

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '关联用户服务id'")
    private Long serviceId;

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '剩余服务次数'")
    private Integer quantity;

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '服务卡有效期开始'")
    private Date startDate;

    @Column(columnDefinition = "bigint(20) COMMENT '服务卡有效期截止'")
    private Date endDate;
}
