package com.xxx.hep.description.pojo;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_description")
@Data
public class Description implements Serializable {
    private String description;//用户描述

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;//表id

    private Integer userId;//用户id

}
