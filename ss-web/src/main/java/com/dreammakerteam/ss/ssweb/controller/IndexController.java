package com.dreammakerteam.ss.ssweb.controller;


import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.ssweb.XyApi;
import com.dreammakerteam.ss.ssweb.pojo.vo.UserServiceVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class IndexController {



    @GetMapping
    public List<Serializable> index() {
        return Arrays.asList('1', "2");
    }

    @GetMapping("/2")
    public Object index2() {
        return "2";
    }

    @GetMapping("/3")
    public Long index3() {
        return 3L;
    }
    @GetMapping("/4")
    public UserServiceVO index4() {
        return UserServiceVO.builder().id(12L).serviceName("哈哈").build();
    }
    @GetMapping("/8")
    public List<UserServiceVO> index8() {
        return Collections.singletonList(UserServiceVO.builder().id(12L).serviceName("哈哈").build());
    }
    @GetMapping("/5")
    public void index5() {
        System.out.println(1);
    }

    @GetMapping("/10")
    public int index10() {
        return 12;
    }
    @GetMapping("/7")
    public Object index7() {
        return getapi().index4();
    }
    @GetMapping("/9")
    public Object index9() {
        return getapi().index8();
    }
    @GetMapping("/11")
    public Object index11() {
        return getapi().index10();
    }
    @GetMapping("/12")
    public Object index12() {
//        getapi().index5();
        return null;
    }

    private XyApi getapi() {
        return Feign.builder()
                .decoder((response, type) -> {
                    JavaType javaType;
                    ObjectMapper mapper = new ObjectMapper();

                    if (type instanceof ParameterizedType) {
                        ParameterizedType pType = (ParameterizedType) type;
                        Type[] actualTypeArguments = (pType).getActualTypeArguments();
                        Class[] classList = new Class[actualTypeArguments.length];
                        for (int i = 0; i < actualTypeArguments.length; i++) {
                            classList[i] = (Class) actualTypeArguments[i];
                        }
                        JavaType innerType = mapper.getTypeFactory().constructParametricType((Class) pType.getRawType(), classList);
                        javaType = mapper.getTypeFactory().constructParametricType(HttpResponse.class, innerType);
                    } else if (type instanceof Class) {
                        javaType = mapper.getTypeFactory().constructParametricType(HttpResponse.class, (Class) type);
                    } else {
                        throw new RuntimeException("不支持的类型");
                    }

                    HttpResponse<UserServiceVO> o = mapper.readValue(response.body().asInputStream(), javaType);
                    return o.getData();
                })
                .target(XyApi.class, "http://localhost:8080/api");
    }

    @GetMapping("/6")
    public ResponseEntity<byte[]> index6() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", new String("张三.txt".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileCopyUtils.copyToByteArray(new File("C:\\Users\\ty850\\Desktop\\应用私钥2048.txt")), headers, HttpStatus.OK);
    }


}
