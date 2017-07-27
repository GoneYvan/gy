package com.gy.base;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/27 0027.
 * 基础引用类
 */
public class BaseDO {

    private Integer id; // id主键
    private Integer status; // 数据状态
    private Date createAt; // 创建时间
    private Date updateAt; // 修改时间
    private Integer version; // 数据版本

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
