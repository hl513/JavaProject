package com.xxx.hep.common.controller;

import com.xxx.hep.common.pojo.PageInfo;
import com.xxx.hep.common.pojo.Result;
import com.xxx.hep.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 通用Controller
 *
 * @param <V> 实体类Vo
 * @param <E> 实体类
 * @param <T> id主键类型
 */
public class CommonController<V, E,T> {

    @Autowired
    private CommonService<V, E,T> commonService;
    
    /*
        CRUD、分页、排序测试
     */
    //    @PostMapping("page")
    @RequestMapping("page")
    public Result<PageInfo<V>> page(V entityVo) {
        return commonService.page(entityVo);
    }

    //    @PostMapping("list")
    @RequestMapping("list")
    public Result<List<V>> list(V entityVo) {
        return commonService.list(entityVo);
    }

    //    @GetMapping("get/{id}")
    @RequestMapping("get/{id}")
    public Result<V> get( @PathVariable("id") T id) {
        return commonService.get(id);
    }

    //    @PostMapping("save")
    @RequestMapping("save")
    public Result<V> save( V entityVo) {
        return commonService.save(entityVo);
    }

    //    @GetMapping("delete/{id}")
    @RequestMapping("delete/{id}")
    public Result<T> delete( @PathVariable("id") T id) {
        /*
        批量删除
        @DeleteMapping("deleteBatch")
        public Result<T> deleteBatch(@RequestBody List<String> ids){}
        前端调用：
        $.ajax({
            url: ctx + "deleteBatch",
            type: "DELETE",
            data: JSON.stringify([id1,id2]),
            dataType: "JSON",
            contentType: 'application/json',
            success: function (data) { 

            }
        });
         */
        return commonService.delete(id);
    }
}
