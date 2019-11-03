package com.dreammakerteam.ss.ssweb.config;


import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@Configuration
public class MyBatisConfig {
    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return configuration -> configuration.getTypeHandlerRegistry().setDefaultEnumTypeHandler(EnumOrdinalTypeHandler.class);
    }
}
