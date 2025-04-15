package com.xxx.hep.controller;


import com.xxx.hep.pojo.PageCondition;
import com.xxx.hep.pojo.PageInfo;
import com.xxx.hep.pojo.Result;
import com.xxx.hep.pojo.UserInfo;
import com.xxx.hep.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/UserInfo/")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    // http://localhost:10086/UserInfo/getAllUserInfo
    @RequestMapping("/getAllUserInfo")
    public ModelAndView getAllUserInfo(){
        Result result=userInfoService.getAllUser();
        ModelAndView mv=new ModelAndView();
        mv.addObject("UserInfoList",result.getData());
        mv.setViewName("index.html");
        return mv;
    }

    // http://localhost:10086/UserInfo/page
    @RequestMapping("page")
    public Result<PageInfo<UserInfo>> page(UserInfo entity, PageCondition pageCondition) {
        return userInfoService.page(entity,pageCondition);
    }

    // http://localhost:10086/UserInfo/list
    @RequestMapping("list")
    public Result<List<UserInfo>> list(UserInfo entity) {
        return userInfoService.list(entity);
    }

    // http://localhost:10086/UserInfo/get/55
    @RequestMapping("get/{id}")
    public Result<UserInfo> get(@PathVariable("id") Integer id) {
        return userInfoService.get(id);
    }

    @RequestMapping("save")
    public Result<UserInfo> save(UserInfo entity) {
        return userInfoService.save(entity);
    }

    // http://localhost:10086/UserInfo/delete/55
    @RequestMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable("id") Integer id){
        return userInfoService.delete(id);
    }
}
