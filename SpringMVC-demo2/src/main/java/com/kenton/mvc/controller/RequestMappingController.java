package com.kenton.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Kenton
 * @description 控制类
 * @date: 2022/6/22 19:32
 */
@Controller
//@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping(
            value = {"/testRequestMapping","test"},
            method = {RequestMethod.GET,RequestMethod.POST},
            params = {"username=admin"}
    )
    public String success(){
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @PostMapping("/testPostMapping")
    public String testPostMapping(){
        return "success";
    }

    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password=123456"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }

    @RequestMapping("/a?a/testAnt")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/a*a/testAntTwo")
    public String testAntTwo(){
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id:"+id+",username"+username);
        return "success";
    }
 }
