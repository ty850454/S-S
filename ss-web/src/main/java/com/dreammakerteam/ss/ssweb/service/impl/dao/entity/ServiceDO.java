package com.dreammakerteam.ss.ssweb.service.impl.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@ToString
@Entity
public class ServiceDO extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
