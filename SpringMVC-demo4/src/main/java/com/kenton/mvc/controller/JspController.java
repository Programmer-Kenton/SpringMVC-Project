package com.kenton.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Kenton
 * @description 控制类
 * @date: 2022/6/26 12:42
 */
@Controller
public class JspController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
