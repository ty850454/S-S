package com.dreammakerteam.ss.core.dao.entity;

import com.dreammakerteam.ss.api.enums.MsgTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "wx_system_msg", indexes = {@Index(columnList="userId,unread")})
@org.hibernate.annotations.Table(appliesTo = "wx_system_msg", comment = "消息")
public class SystemMsgDO extends BaseDO {

    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '关联用户id，消息接收方'")
    private Long userId;

    @Column(nullable = false, columnDefinition = "TINYINT(1) COMMENT '是否未读'")
    private Boolean unread;

    @Column(nullable = false, columnDefinition = "TINYINT(1) COMMENT '消息类型'")
    private MsgTypeEnum type;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '标题'")
    private String title;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '内容'")
    private String content;


    @Column(nullable = false, columnDefinition = "TINYINT(1) COMMENT '是否已使用扩展'")
    private Boolean extendUsed;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '扩展信息'")
    private String extendInfo;


}
