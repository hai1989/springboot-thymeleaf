package com.renren.jinkong.springbootThymeleaf.controller;

import com.renren.jinkong.springbootThymeleaf.entity.User;
import com.renren.jinkong.springbootThymeleaf.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

import java.util.*;

/**
 * Program:       springboot-thymeleaf
 * package        com.renren.jinkong.springbootThymeleaf.service
 * ClassName:     UserController
 * Description:   This is  a  class!
 * Date:          Created in  2019/6/20 16:53
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private  User user;
    @Value("${welcome}")
    private String wel;

    //add-form
    @GetMapping("add")
   public  ModelAndView addUser(Model  model){
        model.addAttribute("user",new User());
        model.addAttribute("title","用户新增页面");
        return   new ModelAndView("users/form","addUser",model);
    }

    //show-table
    @PostMapping("show")
    public String showUser(@ModelAttribute  User  user,Model model){
        model.addAttribute("title","用户展示页面");
        model.addAttribute("user",user);
        log.info("------sex="+user.getSex());
        log.info("------age="+user.getAge());
         return "users/show";
    }

    //modifiey-form

    //delete-button


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String showOne(Model model){
//        User user =  new User();
        user.setId(Utils.getUUID());
        user.setName("张三");
        user.setPassword("12345678");
        user.setAddress("北京海淀区上地18号");
        user.setAge(19);
        user.setSex('0');
        user.setPhone(13501031165L);
        user.setEmail("1002089167@qq.com");
        user.setStatus(0);
        user.setCreateTime(Utils.getDateStr("yyyy-MM-dd HH:mm:ss"));
        user.setUpdateTime(Utils.getDateStr("yyyy-MM-dd HH:mm:ss"));
        String sexStr = null;
        if(user.getSex()==0){
            sexStr = "男";
        }
        else if(user.getSex()==1){
            sexStr = "女";
        }
        else{
            sexStr = "未知";
        }
        String statusStr = null;
        if(user.getStatus()==0){
            statusStr = "正常";
        }
        else if(user.getStatus()==1){
            statusStr = "不正常";
        }
        else{
            statusStr = "未知";
        }
        model.addAttribute("users",user);
        model.addAttribute("sex",sexStr);
        model.addAttribute("status",statusStr);//显示普通文本
        model.addAttribute("wel",wel);//信息是存在资源文件中
        model.addAttribute("name1","<span style='color:red'>Jerry</span>");
        return "users/lists";
    }

    @RequestMapping(value = "/myList",method = RequestMethod.GET)
    public ModelAndView showList(Model model){

        List<User>  list =  new ArrayList<>();
        for(int i=0;i<5;i++){
            User user = new User();
            user.setId("idididid1"+i);
            user.setName("name1"+i);
            user.setPassword("passwd1"+i);
            list.add(user);
        }
        model.addAttribute("list",list);
        return  new ModelAndView("users/userList","userModel",model);
//        return "users/userList";
    }

    @RequestMapping(value = "/myMap",method = RequestMethod.GET)
    public String showMap(Model model){
        Map<String ,User> map =  new HashMap<>();
        for(int i=0;i<5;i++){
            User user = new User();
            user.setId("idididid2"+i);
            user.setName("name2"+i);
            user.setPassword("passwd2"+i);
            map.put("map-"+i,user);
        }
        model.addAttribute("map",map);
        return "users/userMap";
    }

    @RequestMapping(value = "/mySet",method = RequestMethod.GET)
    public String showSet(Model model){

        Set<User> set =  new HashSet<>();
        for(int i=0;i<5;i++){
            User user = new User();
            user.setId("idididid3"+i);
            user.setName("name3"+i);
            user.setPassword("passwd3"+i);
            set.add(user);
        }
        model.addAttribute("set",set);
        return "users/userSet";
    }
}
