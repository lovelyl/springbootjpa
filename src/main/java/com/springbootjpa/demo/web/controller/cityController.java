package com.springbootjpa.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springbootjpa.demo.domain.City;
import com.springbootjpa.demo.service.cityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liyuanlin on 2016/8/15.
 */
@Controller
@RequestMapping("/city")
public class cityController {

    @Autowired
    private cityService cityService;

    @RequestMapping("/")
    public String index() {
        return "city/index";
    }

    @ResponseBody
    @RequestMapping("/findOne/{id}")
    public City findOne(@PathVariable("id") int id) {
        return cityService.getOne(id);
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public JSON findAll() {
        JSONObject result = new JSONObject();
        result.put("data", cityService.getAll());
        return result;
    }

    @ResponseBody
    @RequestMapping("/findall")
    public JSON findall(
            @PageableDefault(value = 10, size = 0, page = 10) Pageable pageable
    ) {
        JSONObject result = new JSONObject();
        result.put("data", cityService.getAll(pageable));
        return result;
    }

    @ResponseBody
    @RequestMapping("delete/{id}")
    public ModelMap deleteCity(@PathVariable("id")int id){
        ModelMap modelMap=new ModelMap();
        cityService.deleteCity(id);
        modelMap.put("msg","删除成功");
        return modelMap;
    }
}