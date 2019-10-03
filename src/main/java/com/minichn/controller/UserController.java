package com.minichn.controller;

import com.minichn.pojo.MinichnJSONResult;
import com.minichn.pojo.User;
import com.minichn.pojo.UserLombok;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by minichn on 2019/8/15 0015.
 */

//@Controller
@RestController    // @RestController = @Controller + @ResponseBody  //IDEA中快捷键使用ctrl+shift+o可以把所有没有用的一些包移除
@RequestMapping("/user")
@Slf4j    //logback日志框架使用
public class UserController {

    @RequestMapping("/getUser")
//	@ResponseBody
    public User getUser() {

        User u = new User();
        u.setName("minichn-User未封装（不携带状态）");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("minichn-User未封装（不携带状态）");
        u.setDesc("hello minichn-User未封装（不携带状态）~~");

        return u;
    }

    @RequestMapping("/getUserJson")
    public MinichnJSONResult getUserJson() {

        User u = new User();
        u.setName("minichn-User已封装（携带状态）");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("minichn-User已封装（携带状态）");
        u.setDesc("hello minichn-User已封装（携带状态）~~hello minichn-User已封装（携带状态）~~");

        return MinichnJSONResult.ok(u);
    }

    @RequestMapping("/getUserLombokJson")
    public MinichnJSONResult getUserLombokJson() {

        UserLombok u = new UserLombok();
        u.setName("minichn-UserLombok已封装（携带状态）且POJO搬到龙目岛");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("minichn-UserLombok已封装（携带状态）且POJO搬到龙目岛");
        u.setDesc("hello minichn-UserLombok已封装（携带状态）~~POJO搬到龙目岛（Lombok）~~");

        log.info("@Slf4j：log.info====执行getUserLombokJson-->(Lombok@log注解)");
        return MinichnJSONResult.ok(u);
    }
}
