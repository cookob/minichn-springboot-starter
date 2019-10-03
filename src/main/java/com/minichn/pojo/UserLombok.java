package com.minichn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

/**
 * Created by minichn on 2019/8/15 0015.
 * 在POJO类上使用了Lombok，IDE上必须要支持Lombok，否则IDE会报错！
 */
//@Data    //包含的范围较广（包含@Getter、@Setter、@ToString、@EqualsAndHashCode，没有无参和全参构造，并且默认所有字段），因此只在特殊情况下才使用@Data
@Getter                         //get方法
@Setter                         //set方法
@NoArgsConstructor              //无参构造
@AllArgsConstructor             //全参构造
@EqualsAndHashCode(of = "id")  //重写Equals、HashCode方法只作用在id字段上，id相同的时候认为是一个相同的对象
@ToString                      //把这个类声明的所有属性都进行ToString(重写ToString)
public class UserLombok {

    private Integer id;
    private String name;

    @JsonIgnore
    private String password;
    private Integer age;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
    private Date birthday;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;
}
