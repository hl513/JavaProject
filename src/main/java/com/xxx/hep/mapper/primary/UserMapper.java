package com.xxx.hep.mapper.primary;

import com.xxx.hep.entity.User;

import java.util.List;

public interface UserMapper  {


    /**
     * 根据ID查详情
     */
    User queryById(Integer id);


    /**
     * 新增数据
     */
    int insert(User user);


    /**
     * 修改数据
     */
    int update(User user);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

    List<User> selectAll();

}
