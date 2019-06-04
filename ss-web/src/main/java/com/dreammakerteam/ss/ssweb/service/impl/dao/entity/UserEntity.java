package com.dreammakerteam.ss.ssweb.service.impl.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class UserEntity extends BaseEntity {
    private String username;
    private String userKey;
    private String nickname;
}