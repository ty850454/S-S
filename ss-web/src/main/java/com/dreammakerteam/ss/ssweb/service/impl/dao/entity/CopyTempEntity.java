package com.dreammakerteam.ss.ssweb.service.impl.dao.entity;


import com.dreammakerteam.ss.core.dao.api.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Setter
@Getter
@ToString
@Entity
public class CopyTempEntity extends BaseEntity {

    public String text;

}
