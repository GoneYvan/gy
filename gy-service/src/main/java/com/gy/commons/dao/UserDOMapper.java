package com.gy.commons.dao;

import com.gy.base.BaseQuery;
import com.gy.commons.domains.UserDO;
import com.gy.commons.queryObjects.UserQuery;

import java.util.List;

public interface UserDOMapper {
    Integer deleteById(BaseQuery record);

    Integer insert(UserDO record);

    Integer update(UserDO record);

    UserDO getById(Integer id);

    List<UserDO> listByQuery(UserQuery record);

}