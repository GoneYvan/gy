package com.gy.commons.queryObjects;

import com.gy.base.BasePagination;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class UserQuery extends BasePagination{

    private Integer id; // 主键ID
    private String name; //姓名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
