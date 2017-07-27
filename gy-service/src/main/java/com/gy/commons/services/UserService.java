package com.gy.commons.services;

import com.gy.base.BaseQuery;
import com.gy.commons.dao.UserDOMapper;
import com.gy.commons.dao.impl.UserDOMapperImpl;
import com.gy.commons.domains.UserDO;
import com.gy.commons.queryObjects.UserQuery;
import com.gy.util.CommonCheckFactory;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class UserService {

    private UserDOMapper userDOMapper;

    public void setUserDOMapper(UserDOMapperImpl userDOMapper) {
        this.userDOMapper = userDOMapper;
    }

    /**
     * 新增一个用户
     * @param userDO
     * @return
     */
    public Integer addUser(UserDO userDO){
        if(CommonCheckFactory.checkObjectNull(userDO)){
            return 0;
        }else{
            return userDOMapper.insert(userDO);
        }
    }

    /**
     * 删除用户（逻辑删除）
     * @param id
     * @param version
     * @return
     */
    public boolean deleteUser(Integer id, Integer version){
        if(CommonCheckFactory.checkObjectNull(id) || CommonCheckFactory.checkObjectNull(version)){
            return false;
        }
        return CommonCheckFactory.checkSuccess(userDOMapper.deleteById(new BaseQuery(id, version)));
    }

    /**
     * 修改用户
     * @param userDO
     * @return
     */
    public boolean updateUser(UserDO userDO){
        if(CommonCheckFactory.checkObjectNull(userDO)
                || CommonCheckFactory.checkObjectNull(userDO.getId())){
            return false;
        }
        return CommonCheckFactory.checkSuccess(userDOMapper.update(userDO));
    }

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    public UserDO getById(Integer id){
        if(CommonCheckFactory.checkObjectNull(id)){
            return null;
        }
        return userDOMapper.getById(id);
    }

    /**
     * 根据条件检索用户信息
     * @param query
     * @return
     */
    public List<UserDO> listByQuery(UserQuery query){
        return userDOMapper.listByQuery(query);
    }
}
