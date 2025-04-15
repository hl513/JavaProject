package com.xxx.hep.dao;

import com.xxx.hep.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {
    @Query(value = "from UserInfo ") //HQL
//    @Query(value = "select * from tb_user",nativeQuery = true)//原生SQL
    List<UserInfo> getAllUser();
}
