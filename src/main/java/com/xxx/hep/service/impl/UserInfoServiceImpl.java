package com.xxx.hep.service.impl;


import com.xxx.hep.dao.UserInfoRepository;
import com.xxx.hep.pojo.PageCondition;
import com.xxx.hep.pojo.PageInfo;
import com.xxx.hep.pojo.Result;
import com.xxx.hep.pojo.UserInfo;
import com.xxx.hep.service.UserInfoService;
import com.xxx.hep.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserInfoServiceImpl  implements UserInfoService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public Result<PageInfo<UserInfo>> page(UserInfo entity , PageCondition pageCondition) {
        Page<UserInfo> page = userInfoRepository.findAll(Example.of(CopyUtil.copy(entity, UserInfo.class)), pageCondition.getPageable());
        int records = (int) page.getTotalElements();
        int pageSize = page.getSize();
        int total = records % pageSize == 0 ? records / pageSize : records / pageSize + 1;
        PageInfo<UserInfo> pageInfo = new PageInfo<>();
        pageInfo.setPage(page.getNumber() + 1);//页码
        pageInfo.setPageSize(pageSize);//页面大小
        pageInfo.setRows(page.getContent());//分页结果
        pageInfo.setRecords(records);//总记录数
        pageInfo.setTotal(total);//总页数
        return Result.of(pageInfo);
    }

    @Override
    public Result<List<UserInfo>> list(UserInfo entity) {
        List<UserInfo> entityList = userInfoRepository.findAll(Example.of(entity));
        return Result.of(entityList);
    }

    @Override
    public Result<UserInfo> get(Integer id) {
        Optional<UserInfo> optionalE = userInfoRepository.findById(id);
        if (!optionalE.isPresent()) {
            throw new RuntimeException("ID不存在！");
        }
        return Result.of(optionalE.get());
    }

    @Override
    public Result<UserInfo> save(UserInfo entity) {
        UserInfo user = userInfoRepository.save(entity);
        return Result.of(user);
    }

    @Override
    public Result<Integer> delete(Integer id) {
        userInfoRepository.deleteById(id);
        return Result.of(id);
    }

    @Override
    public Result getAllUser() {
        List<UserInfo> userList = userInfoRepository.getAllUser();
        if(userList != null && userList.size()>0){
            return Result.of(userList);
        }else {
            return Result.of(userList,false,"获取失败！");
        }
    }
}
