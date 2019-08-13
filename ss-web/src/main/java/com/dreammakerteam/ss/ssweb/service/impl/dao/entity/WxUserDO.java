package com.dreammakerteam.ss.ssweb.service.impl.dao.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity
public class WxUserDO extends BaseEntity {

    private String openid;


}
