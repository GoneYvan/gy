package com.gy.commons;

import com.gy.base.BaseQuery;
import com.gy.base.BaseTest;
import com.gy.commons.dao.UserDOMapper;
import com.gy.commons.domains.UserDO;
import com.gy.commons.queryObjects.UserQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

@ContextConfiguration(locations = "/META-INF/spring/spring_user_service.xml")
@Transactional
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDOMapper userDOMapper;

    private static final String name = "陈六";
    private static final String phone = "12512345678";
    private static final Integer age = 25;
    private static final String birth = "1999-11-11";

    @Test
    public void test(){
        UserDO userDO = new UserDO();
        userDO.setName(name);
        userDO.setPhone(phone);
        userDO.setAge(age);
        userDO.setBirthday(birth);
        Integer id = userDOMapper.insert(userDO);
        Assert.assertNotNull(id);
        Assert.assertNotNull(userDO.getId());

        userDO = userDOMapper.getById(userDO.getId());
        Assert.assertNotNull(userDO.getCreateAt());

        userDO.setAge(20);
        userDOMapper.update(userDO);
        userDO = userDOMapper.getById(userDO.getId());
        Assert.assertNotNull(userDO.getAge());
        Assert.assertEquals(userDO.getAge(), Integer.valueOf(20));

        UserQuery userQuery = new UserQuery();
        userQuery.setName(name);
        List<UserDO> userDOList = userDOMapper.listByQuery(userQuery);
        Assert.assertNotNull(userDOList);

        userDOMapper.deleteById(new BaseQuery(id, userDO.getVersion()));

    }
}
