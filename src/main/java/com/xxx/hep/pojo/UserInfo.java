package com.xxx.hep.pojo;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //IDENTITY 自增
    private Integer id;

    @Column(name = "username")//命名相同或驼峰标识（与数据库下划线映射）可以不用写
    private String username;

    private String password;

    private Date created;

    private String descriptionId;

    @OneToOne
    @JoinColumn(name = "descriptionId",referencedColumnName = "id", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    //用户描述信息
    private Description description;

}
