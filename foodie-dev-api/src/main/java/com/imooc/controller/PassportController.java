package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.StuService;
import com.imooc.service.UserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/18 17:42
 */
//@Controller
@Api(value = "注册登录",tags = "用于登录注册的相关接口")
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService usersService;

    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExsit(@RequestParam String username){
        //1、判断用户名是否为空
        if(StringUtils.isBlank(username)){
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //2、查找用户名是否存在
        boolean isExsit=usersService.queryUsernameIsExist(username);
        if(isExsit){
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }
        //3、请求成功，用户名不重复
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO, HttpServletRequest request,
                                  HttpServletResponse response){

        String username=userBO.getUsername();
        String password=userBO.getPassword();
        String confirmPwd=userBO.getConfirmPassword();

        //1、判断用户名是否为空
        if(StringUtils.isBlank(username)  ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)){
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }
        //2、查找用户名是否存在
        boolean isExsit=usersService.queryUsernameIsExist(username);
        if(isExsit){
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }
        if(password.length()<6){
            return IMOOCJSONResult.errorMsg("密码长度不能小于6");
        }
        if(!password.equals(confirmPwd)){
            return IMOOCJSONResult.errorMsg("两次密码输入不一致");
        }
        Users userResult=usersService.createUser(userBO);
        userResult=setNullProperty(userResult);

        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(userResult),true);

        //3、请求成功，用户名不重复
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserBO userBO, HttpServletRequest request,
                                 HttpServletResponse response){
        String username=userBO.getUsername();
        String password=userBO.getPassword();

        //1、判断用户名是否为空
        if(StringUtils.isBlank(username)  ||
                StringUtils.isBlank(password)){
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }
        Users userResult=usersService.queryUserForLogin(username,MD5Utils.toMD5(password));
        if(userResult==null){
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }
        userResult=setNullProperty(userResult);

        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(userResult),true);
        //3、请求成功，用户名不重复
        return IMOOCJSONResult.ok(userResult);
    }

    private Users setNullProperty(Users userResult){
        userResult.setPassword(null);
        userResult.setEmail(null);
        userResult.setRealname(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        return  userResult;
    }


    @ApiOperation(value = "用户退出登录",notes = "用户退出登录",httpMethod = "POST")
    @PostMapping("/logout")
    public IMOOCJSONResult logout(@RequestParam String userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response){
        CookieUtils.deleteCookie(request,response,"user");

        //TODO 用户退出登录需要清空购物车
        //TODO 分布式会话中需要清除用户数据

        return IMOOCJSONResult.ok();
    }
}
