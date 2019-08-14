package com.dreammakerteam.ss.core.dao.entity;

import com.dreammakerteam.ss.api.enums.ValidEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class BaseDO {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "com.dreammakerteam.ss.core.sdk.snowflake.IdGenerator")
    private Long id;

    @Version
    @Column(nullable = false)
    private Long version;

    @Column(nullable = false)
    private ValidEnum valid = ValidEnum.VALID;

    @CreatedDate
    @Column(updatable = false, nullable = false, columnDefinition = "TIMESTAMP")
    private Date createTime;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date updateTime;

    public String getStringId() {
        return id != null ? id.toString() : null;
    }


}
