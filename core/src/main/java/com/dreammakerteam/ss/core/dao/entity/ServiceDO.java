package com.dreammakerteam.ss.core.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 服务
 *
 * @author xy
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "wx_service", indexes = {@Index(name="userId",columnList="userId")})
@org.hibernate.annotations.Table(appliesTo = "wx_service", comment = "服务")
public class ServiceDO extends BaseDO {

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '服务名'")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '封面'")
    private String cover;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '介绍'")
    private String intro;

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '关联用户id'")
    private Long userId;
}
