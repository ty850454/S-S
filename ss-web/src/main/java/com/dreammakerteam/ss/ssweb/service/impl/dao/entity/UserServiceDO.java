package com.dreammakerteam.ss.ssweb.service.impl.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity
public class UserServiceDO extends BaseEntity {

    @Column(nullable = false)
    private Long wxUserId;

    @Column(nullable = false)
    private Long serviceId;

    @Column(nullable = false)
    private Integer quantity;
}
