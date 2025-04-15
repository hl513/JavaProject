package com.xxx.hep.vo;


import com.xxx.hep.pojo.PageCondition;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfoVo extends PageCondition implements Serializable {
    private Date created;//创建时间

    private String descriptionId;//关联详情id

    private Integer id;//表id

    private String password;//密码

    private String username;//用户名

}
