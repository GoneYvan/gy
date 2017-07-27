package com.gy.base;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class BaseQuery {

    private Integer id; // 主键ID
    private Integer version; //版本ID

    public BaseQuery(Integer id, Integer version){
        this.id = id;this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
