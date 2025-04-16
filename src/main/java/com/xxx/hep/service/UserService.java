package com.xxx.hep.service;

import com.xxx.hep.entity.User;
import com.xxx.hep.utils.Result;

import java.util.List;

/**
 * @Author hep
 * @Desc 用户信息表(User)表服务接口
 */
public interface UserService {



    /**
     * 根据ID查详情
     */
    Result<User> queryById(Integer id);

    /**
     * 新增数据
     */
    Result<Integer> insert(User user);

    /**
     * 修改数据
     */
    Result<Integer> update(User user);

    /**
     * 通过主键删除数据
     */
    Result<Integer> deleteById(Integer id);

    List<User> selectAll();
}
