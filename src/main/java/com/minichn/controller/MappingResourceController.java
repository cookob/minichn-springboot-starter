package com.minichn.controller;

import com.minichn.pojo.MinichnJSONResult;
import com.minichn.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by minichn on 2019/8/15 0015.
 *
 * 映射资源文件
 *
 * 步骤：1.pom引入；2.编写资源文件；3.编写资源映射pojo类；
 *
 */
@RestController
public class MappingResourceController {

    @Autowired
    private Resource resource;

    @RequestMapping("/mappingResource")
    public Object hello() {
        return "hello springboot mapping resource~~";
    }

    @RequestMapping("/getResource")
    public MinichnJSONResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return MinichnJSONResult.ok(bean);
    }
}
