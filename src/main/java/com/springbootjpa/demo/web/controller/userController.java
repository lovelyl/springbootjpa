package com.springbootjpa.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springbootjpa.demo.domain.User;
import com.springbootjpa.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liyuanlin on 2016/8/13.
 */
@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @RequestMapping("/")
    public String index(){return "/index";}

    @ResponseBody
    @RequestMapping("/findOne")
    public User findOne(@PathVariable("id")int id){
        return userService.getOne(id);
    }
    @ResponseBody
    @RequestMapping("/findAll")
    public JSON findAll(){
        JSONObject result=new JSONObject();
        result.put("data",userService.getAll());
        return result;
    }

    @ResponseBody
    @RequestMapping("/FindALL")
    public JSON findAll(
            @PageableDefault(
                    size = 10,
                    value = 10,
                    page = 0,
                    direction = Sort.Direction.ASC
            )Pageable pageable
            ){
        JSONObject result=new JSONObject();
        result.put("data",userService.getAll(pageable));
        return result;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable("id")int id){
        ModelMap result=new ModelMap();
        userService.deleteUser(id);
        result.put("msg","删除成功");
        return result;
    }


}
