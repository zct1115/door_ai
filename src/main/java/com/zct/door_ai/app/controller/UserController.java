package com.zct.door_ai.app.controller;

import com.zct.door_ai.app.bean.User;
import com.zct.door_ai.app.service.UserService;
import com.zct.door_ai.base.BaseController;
import com.zct.door_ai.bean.CurrentUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户控制层
 */
@Api(value = "户主接口服务",description = "户主登录注册的api接口")
@RequestMapping("/user")
@Controller
public class UserController extends BaseController {

    @Autowired
    public UserService userService;

    /**
     * 用户登录入口
     * @param username 用户名
     * @param password 密码
     * @param response 回调json数据 成功返回200，失败返回500
     */
    @ApiOperation("登录")
    @PostMapping("/logincheck")
    public void userLogin(@ApiParam("用户名")@RequestParam String username,@ApiParam("密码") @RequestParam String password, HttpServletResponse response){
        Map<String,Object> user=userService.checkUserLogin(username,password);
        if(user==null){
            renderFail(response,"登录失败");
        }else {
            renderSuccess(response,"登录成功");
        }
    }

    /**
     * 户主登记注册审核
     * @param user
     * @param response
     */
    @ApiOperation("注册")
    @PostMapping("/register")
    public void userResigter(@RequestBody CurrentUser user, HttpServletResponse response){
       int result=userService.registercheck(user);
       switch (result){
           case 0:
               userService.register(user);
               renderSuccess(response,"注册成功");
               break;
           case 1:
               renderFail(response,"该身份证已被注册");
               break;
           case 2:
               renderFail(response,"该用户名已被注册");
               break;
           case 3:
               renderFail(response,"该门户已被注册");
               break;
       }
    }
}
