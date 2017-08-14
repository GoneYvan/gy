package com.gy.commons.dao.impl;

import com.gy.base.BaseQuery;
import com.gy.commons.dao.UserDOMapper;
import com.gy.commons.domains.UserDO;
import com.gy.commons.queryObjects.UserQuery;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class UserDOMapperImpl extends SqlSessionDaoSupport implements UserDOMapper {

    private final static String namespace = "com.gy.commons.dao.UserDOMapper.";

    @Override
    public Integer deleteById(BaseQuery record) {
        return getSqlSession().update(namespace + "deleteById", record);
    }

    @Override
    public Integer insert(UserDO record) {
        return getSqlSession().insert(namespace + "insert", record);
    }

    @Override
    public Integer update(UserDO record) {
        return getSqlSession().update(namespace + "update", record);
    }

    @Override
    public UserDO getById(Integer id) {
        return getSqlSession().selectOne(namespace + "getById", id);
    }

    @Override
    public List<UserDO> listByQuery(UserQuery record) {
        return getSqlSession().selectList(namespace + "listByQuery", record);
    }

    @Override
    public UserDO getByAccount(String account) {
        return getSqlSession().selectOne(namespace + "getByAccount", account);
    }
}
