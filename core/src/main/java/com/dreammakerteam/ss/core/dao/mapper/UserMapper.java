package com.dreammakerteam.ss.core.dao.mapper;

import com.dreammakerteam.ss.api.enums.ValidEnum;
import com.dreammakerteam.ss.core.dao.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

@Mapper
public interface UserMapper {

    @Select("select * from wx_user where id=#{id}")
//    @Results({
//            @Result(property = "valid",  column = "valid", javaType = ValidEnum.class, typeHandler = EnumOrdinalTypeHandler.class)
//    })
    UserDO findById(Long id);



}
