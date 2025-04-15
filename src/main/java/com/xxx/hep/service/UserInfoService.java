package com.xxx.hep.service;


import com.xxx.hep.pojo.PageCondition;
import com.xxx.hep.pojo.PageInfo;
import com.xxx.hep.pojo.Result;
import com.xxx.hep.pojo.UserInfo;

import java.util.List;

public interface UserInfoService  {
    Result<PageInfo<UserInfo>> page(UserInfo entity, PageCondition pageCondition);

    Result<List<UserInfo>> list(UserInfo entity);

    Result<UserInfo> get(Integer id);

    Result<UserInfo> save(UserInfo entity);

    Result<Integer> delete(Integer id);

    Result getAllUser();
}
