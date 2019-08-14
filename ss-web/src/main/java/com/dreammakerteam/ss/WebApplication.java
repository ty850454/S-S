package com.dreammakerteam.ss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * web app 启动类
 *
 * @author xy
 */
@SpringBootApplication
@EnableJpaAuditing
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
//
//    @Bean
//    public HttpMessageConverters customConverters() {
//        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
//        // 全局的日期格式化，一般不写全局，而是在属性上面加@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
//        // 不显示为null的字段
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
//        objectMapper.registerModule(simpleModule);
//
//        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        return new HttpMessageConverters(jackson2HttpMessageConverter);
//    }
}
