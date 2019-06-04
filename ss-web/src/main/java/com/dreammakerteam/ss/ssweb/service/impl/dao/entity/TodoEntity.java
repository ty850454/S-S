package com.dreammakerteam.ss.ssweb.service.impl.dao.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Setter
@Getter
@ToString
@Entity
public class TodoEntity extends BaseEntity {


    public String name;



}
