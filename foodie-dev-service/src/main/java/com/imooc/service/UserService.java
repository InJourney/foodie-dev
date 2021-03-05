package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/22 10:42
 */
public interface UserService {
    //验证用户名是否存在
    public boolean queryUsernameIsExist(String username);
    //创建用户
    public Users createUser(UserBO userBO);

    //实现登录
    public Users queryUserForLogin(String username,String password);
}
