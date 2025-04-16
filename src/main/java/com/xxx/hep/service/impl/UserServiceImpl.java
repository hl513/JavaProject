package com.xxx.hep.service.impl;

import com.xxx.hep.entity.User;
import com.xxx.hep.mapper.primary.UserMapper;
import com.xxx.hep.service.UserService;
import com.xxx.hep.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hep
 * @Desc 用户信息表(User)表服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;

    @Override
    public Result<User> queryById(Integer id) {
        User user = userMapper.queryById(id);
        return Result.ok(user);
    }


    @Override
    public Result<Integer> insert(User user) {
        int num = userMapper.insert(user);
        return Result.ok(200,"新增成功",num);
    }


    @Override
    public Result<Integer> update(User user) {
        int num = userMapper.update(user);
        return Result.ok(200,"更新成功",num);
    }


    @Override
    public Result<Integer> deleteById(Integer id) {
        int num = userMapper.deleteById(id);
        return Result.ok(200,"删除成功",num);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

}
