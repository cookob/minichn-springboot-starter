package com.minichn.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by minichn on 2019/8/15 0015.
 * 资源映射的POJO类 （注：使用了Lombok，IDE上必须要支持Lombok，否则IDE会报错！）
 */
@Getter
@Setter
@Configuration           //引用资源文件的配置 [官方文档中说明了：注解处理器还支持使用的@Data，@Getter和@Setter Lombok的注释]
@ConfigurationProperties(prefix="com.minichn.opensource")    //前缀，做映射时只会把前缀后面的属性映射到Resource的字段里面
@PropertySource(value="classpath:resource.properties")      //资源文件的地址
public class Resource {
    private String name;
    private String website;
    private String language;
}
