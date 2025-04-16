package com.xxx.hep.controller;

import com.xxx.hep.anno.SysLog;
import com.xxx.hep.entity.User;
import com.xxx.hep.service.UserService;
import com.xxx.hep.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Author hep
 * @Desc 用户信息表(User)表控制层
 */
@Api(tags = "用户信息表")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private  UserService userService;

    // http://localhost:10094/user/selectAll
    @SysLog("查询所有用户信息")
    @GetMapping(value = "/selectAll")
    public Result selectAll() throws Exception {
        List<User> users = userService.selectAll();
        return Result.ok(users);
    }

    @ApiOperation("用户信息表-根据ID查详情")
    @SysLog("用户信息表-根据ID查详情")
    @PostMapping("/queryById")
    public Result<User> queryById(@RequestBody User param) {
        return userService.queryById(param.getId());
    }


    @ApiOperation("用户信息表-新增数据")
    @SysLog("用户信息表-新增数据")
    @PostMapping("/insert")
    public  Result<Integer> insert(@RequestBody User param) {
        return userService.insert(param);
    }


    @ApiOperation("用户信息表-编辑数据")
    @SysLog("用户信息表-编辑数据")
    @PostMapping("/update")
    public  Result  update(@RequestBody User param) {
        if (Objects.isNull(param.getId())) {
            return Result.error("ID不能为空");
        }
        return userService.update(param);
    }


    @ApiOperation("用户信息表-删除数据")
    @SysLog("用户信息表-删除数据")
    @PostMapping("/deleteById")
    public  Result deleteById(@RequestBody User param) {
        return userService.deleteById(param.getId());
    }

}
