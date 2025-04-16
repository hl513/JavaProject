package com.xxx.hep.entity;



import lombok.Data;

import java.util.Date;

/**
 * 用户信息表(User)实体类
 *
 * @author hep
 * @since 2025-04-16 09:08:10
 */
@Data
public class User {

    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 出生日期
     */
    private Date birthday;

}
