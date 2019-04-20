package com.example.controller;

import com.example.pojo.Resource;
import com.example.utils.BBResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello() {
        return "Hello SpringBoot ~";
    }

    @RequestMapping("/getResource")
    public BBResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return BBResult.ok(bean);
    }


}
