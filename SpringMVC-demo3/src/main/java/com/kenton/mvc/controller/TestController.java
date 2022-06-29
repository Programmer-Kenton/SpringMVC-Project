package com.kenton.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Kenton
 * @description 扩展类
 * @date: 2022/6/25 18:52
 */
@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("test_view")
    public String testView(){
        return "test_view";
    }

}
