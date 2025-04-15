package com.xxx.hep.vo;

import com.xxx.hep.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

@Data
public class DescriptionVo extends PageCondition implements Serializable {
    private String description;//用户描述

    private Integer id;//表id

    private Integer userId;//用户id

}
