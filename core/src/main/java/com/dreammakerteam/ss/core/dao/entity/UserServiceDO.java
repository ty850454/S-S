package com.dreammakerteam.ss.core.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 用户服务卡
 *
 * @author xy
 */
@Getter
@Setter
@ToString
@Entity
public class UserServiceDO extends BaseDO {

    @Column(nullable = false)
    private Long wxUserId;

    @Column(nullable = false)
    private Long serviceId;

    @Column(nullable = false)
    private Integer quantity;
}
