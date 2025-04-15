package com.xxx.hep.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "User实体Vo")
public class UserVo {
    @ApiModelProperty(value = "用户id",example = "1")
    private Integer id;

    @ApiModelProperty("用户名称")
    private String userName;
}
