package com.kenton.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Kenton
 * @description 控制器
 * @date: 2022/6/22 18:58
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/")
    // "/" --> /WEB-INF/templates/index.html
    public String index(){
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}
