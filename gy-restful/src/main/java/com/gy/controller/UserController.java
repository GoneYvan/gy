package com.gy.controller;

import com.gy.commons.domains.UserDO;
import com.gy.commons.queryObjects.UserQuery;
import com.gy.commons.services.CommonServiceFactory;
import com.gy.commons.services.UserService;
import com.gy.common.UserSession;
import com.gy.util.CommonCheckFactory;
import com.gy.util.JSONResponse;
import com.gy.util.JSONResponseUtil;
import com.gy.util.MD5SignKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService = CommonServiceFactory.getUserService();

    /**
     * 检查账号是否存在
     * @param account
     * @return
     */
    @RequestMapping("/checkAccount")
    public JSONResponse checkAccount(String account){
        if(account == null || account.length() > 20){
            return JSONResponseUtil.error(JSONResponseUtil.PARAM_ERROR,
                    "账号不可为空且在20个字符一下");
        }
        if(getUserDOByAccount(account) != null){
            return JSONResponseUtil.success(null);
        }
        return JSONResponseUtil.fail(null);
    }

    /**
     * 注册新用户
     * @param userDO
     * @return id 成功后的ID
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONResponse register(UserDO userDO){
        if(CommonCheckFactory.checkObjectNull(userDO, userDO.getName(), userDO.getAccount(),
                userDO.getPassword())){
            return JSONResponseUtil.paramNull();
        }

        if(userDO.getPassword().length() < 6 || userDO.getPassword().length() > 18){
            return JSONResponseUtil.error(
                    JSONResponseUtil.PARAM_ERROR, "密码长度6-18位");
        }

        if(getUserDOByAccount(userDO.getAccount()) != null){
            return JSONResponseUtil.error(
                    JSONResponseUtil.PARAM_ERROR, "账号已经存在");
        }
        // 增加用户
        userDO.setPassword(MD5SignKey.MD5(userDO.getPassword())); // 加密
        Integer id = userService.addUser(userDO);
        if(CommonCheckFactory.checkSuccess(id)){
            return JSONResponseUtil.success(id);
        }
        return JSONResponseUtil.fail(null);
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONResponse login(String account, String password){
        if(account == null || password == null){
            return JSONResponseUtil.paramNull();
        }
        UserDO userDO = userService.getByAccount(account);
        if(userDO == null){
            return JSONResponseUtil.error(
                    JSONResponseUtil.PARAM_ERROR, "账户不存在"
            );
        }
        if(MD5SignKey.MD5(password).equals(userDO.getPassword())){
            if(UserSession.getCurrent() == null){
                UserSession userSession = new UserSession();
                userSession.setUserId(userDO.getId());
                UserSession.setCurrent(userSession);
            }
            return JSONResponseUtil.success(userDO);
        }else{
            return JSONResponseUtil.error(
                    JSONResponseUtil.PARAM_ERROR, "密码错误"
            );
        }
    }

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public JSONResponse getUser(Integer id){
        if(id == null){
            return JSONResponseUtil.paramNull();
        }
        UserDO userDO = userService.getById(id);
        if(userDO == null){
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
        if(userDO == null){
            return JSONResponseUtil.paramNull();
        }
        if(userDO.getId() == null){
            return JSONResponseUtil.error(
                    JSONResponseUtil.PARAM_ERROR,  "请求ID为空");
        }
        if(userDO.getVersion() == null){
            return JSONResponseUtil.error(
                    JSONResponseUtil.PARAM_ERROR,  "请求版本数据为空");
        }
        UserDO userDO1 = userService.getById(userDO.getId());
        if(userDO1 == null){
            return JSONResponseUtil.error(
                    JSONResponseUtil.PARAM_ERROR, "用户不存在");
        }
        if(userDO.toModeString().equals(userDO1.toModeString())){
            return JSONResponseUtil.error(JSONResponseUtil.PARAM_ERROR, "没有参数改变");
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
        if(id == null){
            return JSONResponseUtil.error(4000, "请求ID为空");
        }
        if(version == null){
            return JSONResponseUtil.error(4000, "请求版本数据为空");
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


    /**
     * 根据账号获取用户信息
     * @param account
     * @return
     */
    private UserDO getUserDOByAccount(String account){
        return userService.getByAccount(account);
    }



}
