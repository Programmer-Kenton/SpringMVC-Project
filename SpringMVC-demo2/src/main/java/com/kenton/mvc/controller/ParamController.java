package com.kenton.mvc.controller;

import com.kenton.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author: Kenton
 * @description 扩展类
 * @date: 2022/6/24 18:46
 */

@Controller
public class ParamController {
    @RequestMapping("/testServletAPI")
    // 形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password + ",session" +session);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "hehe") String username,
            String password,
            String[] hobby,
            @RequestHeader("Host") String host,
            @RequestHeader(value = "sayHaha",required = true,defaultValue = "笑死我了") String test,
            @CookieValue("JSESSIONID") String JSESSIONID){
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println("test:"+test);
        System.out.println("JSESSIONID:" + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
