package com.dreammakerteam.ss.core.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 服务记录
 *
 * @author xy
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "wx_serviceUseLog", indexes = {@Index(columnList="userServiceId"), @Index(columnList="serviceId"), @Index(columnList="userId")})
@org.hibernate.annotations.Table(appliesTo = "wx_serviceUseLog", comment = "服务记录")
public class ServiceUseLogDO extends BaseDO {

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '关联用户服务卡id'")
    private Long userServiceId;

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '关联服务id'")
    private Long serviceId;

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '关联用户id'")
    private Long userId;
}
