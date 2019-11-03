package com.dreammakerteam.ss.core;


import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {
    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return configuration -> configuration.getTypeHandlerRegistry().setDefaultEnumTypeHandler(EnumOrdinalTypeHandler.class);
    }
}
