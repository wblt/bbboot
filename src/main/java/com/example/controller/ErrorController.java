package com.example.controller;

import com.example.utils.BBResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public BBResult getAjaxerror() {
        int a = 1 / 0;
        return BBResult.ok();
    }
}
