package com.renren.jinkong.springbootThymeleaf.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Program:       springboot-thymeleaf
 * package        com.renren.jinkong.springbootThymeleaf.entity
 * ClassName:     User
 * Description:   This is  a  class!
 * Date:          Created in  2019/6/20 16:userTemp
 * Author         gaohaijiang
 * Version        V1.0.0
 */

@Component
@Data
public class User {
    private String id;//uuid
    private String name;
    private String password;
    private char sex;//姓别：0-男，1-女
    private int age;
    private long phone;//手机号-11位
    private String email;
    private String address;
    private int status;//状态：0-正常，1-不正常
    private String createTime;
    private String updateTime;

}
