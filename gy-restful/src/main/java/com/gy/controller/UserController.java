package com.gy.controller;

import com.gy.commons.domains.UserDO;
import com.gy.commons.queryObjects.UserQuery;
import com.gy.commons.services.CommonServiceFactory;
import com.gy.commons.services.UserService;
import com.gy.util.CommonCheckFactory;
import com.gy.util.JSONResponse;
import com.gy.util.JSONResponseUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService = CommonServiceFactory.getUserService();

    /**
     * 增加新用户
     * @param userDO
     * @return
     */
    @RequestMapping("/add")
    public JSONResponse addUser(UserDO userDO){
        if(CommonCheckFactory.checkObjectNull(userDO)
            || CommonCheckFactory.checkObjectNull(userDO.getName())){
            return JSONResponseUtil.paramNull();
        }
        Integer id = userService.addUser(userDO);
        if(CommonCheckFactory.checkSuccess(id)){
            return JSONResponseUtil.success(id);
        }
        return JSONResponseUtil.fail(null);
    }

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public JSONResponse getUser(Integer id){
        if(CommonCheckFactory.checkObjectNull(id)){
            return JSONResponseUtil.paramNull();
        }
        UserDO userDO = userService.getById(id);
        if(CommonCheckFactory.checkObjectNull(userDO)){
            return JSONResponseUtil.fail(null);
        }
        return JSONResponseUtil.success(userDO);
    }

    /**
     * 修改用户信息
     * @param userDO
     * @return
     */
    @RequestMapping("/update")
    public JSONResponse updateUser(UserDO userDO){
        if(CommonCheckFactory.checkObjectNull(userDO)){
            return JSONResponseUtil.paramNull();
        }
        if(CommonCheckFactory.checkObjectNull(userDO.getId())){
            return JSONResponseUtil.paramError(4000, "请求ID为空");
        }
        if(CommonCheckFactory.checkObjectNull(userDO.getVersion())){
            return JSONResponseUtil.paramError(4000, "请求版本数据为空");
        }
        if(userService.updateUser(userDO)){
            return JSONResponseUtil.success(userDO.getId());
        }
        return JSONResponseUtil.fail(null);
    }

    /**
     * 删除用户
     * @param id
     * @param version
     * @return
     */
    @RequestMapping("/delete")
    public JSONResponse deleteUser(@Param("id") Integer id, @Param("version") Integer version){
        if(CommonCheckFactory.checkObjectNull(id)){
            return JSONResponseUtil.paramError(4000, "请求ID为空");
        }
        if(CommonCheckFactory.checkObjectNull(version)){
            return JSONResponseUtil.paramError(4000, "请求版本数据为空");
        }
        if(userService.deleteUser(id, version)){
            return JSONResponseUtil.success(null);
        }
        return JSONResponseUtil.fail(id);
    }

    /**
     * 条件搜索用户
     * @param userQuery
     * @return
     */
    @RequestMapping("/query")
    public JSONResponse queryUsers(UserQuery userQuery){
        if(userQuery == null){
            userQuery = new UserQuery();
            return JSONResponseUtil.success(userService.listByQuery(userQuery));
        }

        if(userQuery.getPage() != null && userQuery.getPage() > 1){
            if(userQuery.getPageNum() != null && userQuery.getPageNum() > 0){
                userQuery.setStart(userQuery.getPage() * userQuery.getPageNum() -1);
                userQuery.setStop(userQuery.getPageNum());
            }
        }
        if(userQuery.getPageNum() != null && userQuery.getPageNum() > 0){
            userQuery.setStop(userQuery.getPageNum());
        }
        return JSONResponseUtil.success(userService.listByQuery(userQuery));
    }





}
