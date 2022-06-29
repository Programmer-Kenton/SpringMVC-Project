package com.kenton.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/27 17:03
 */
@RestController
public class FileUpAndDownController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/wife2.jpg");
        // 创建输入流
        FileInputStream is = new FileInputStream(realPath);
        // 创建字节数组
        byte[] bytes = new byte[is.available()];
        // 将流读到字节数字中
        is.read(bytes);
        // 创建HttpHeaders对象设置响应头信息
        MultiValueMap<String,String> headers = new HttpHeaders();
        // 设置要下载方式以及下载文件的名字
        headers.add("Context-Disposition","attachment;filename=wife2.jpg");
        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        // 创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        // 关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
        /*System.out.println(photo.getName());
        System.out.println(photo.getOriginalFilename());*/
        // 获取上传的文件名
        String fileName = photo.getOriginalFilename();
        // 获取上床文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 将UUID作为文件名
        String uuid = UUID.randomUUID().toString();
        // 将uuid和后缀名拼接后的结果作为最终的文件名
        fileName = uuid + suffixName;
        // 通过ServletContext获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        // 判断photoPath所对应的路径是否存在
        if (file.exists()) {
            // 若不存在则创建目录
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
