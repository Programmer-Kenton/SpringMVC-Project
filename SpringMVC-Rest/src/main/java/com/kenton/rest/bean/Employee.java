package com.kenton.rest.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/27 10:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;

    private String email;
    private Integer gender;

    public Integer getId(){
        return id;
    }
}
