package com.gy.controller;

import com.gy.util.JSONResponse;
import com.gy.util.JSONResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * 查看所有用户权限
     * @return
     */
    @RequestMapping("/list")
    public JSONResponse listAuthority(){
        Map map = new HashMap();
        map.put(1, "administrator");
        map.put(2, "admin");
        map.put(3, "staff");
        map.put(4, "customer");
        return JSONResponseUtil.success(map);
    }

}
