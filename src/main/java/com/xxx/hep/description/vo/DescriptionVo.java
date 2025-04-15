package com.xxx.hep.description.vo;

import com.xxx.hep. common.pojo.PageCondition;import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class DescriptionVo extends PageCondition implements Serializable {
    private String description;//用户描述

    private Integer id;//表id

    private Integer userId;//用户id

}
