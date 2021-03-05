package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.apache.catalina.User;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/22 10:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper  usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE="www.baidu.com/image";

    /*事务传播 -propagation
    *          REQUIRED：使用当前的事务，如果当前没有事务则自己新建一个事务，子方法必须运行在一个事务中；
    *                    如果当前存在事务，则加入这个事务，成为一个整体
    *          SUPPORTS：如果当前有事务，则使用事务，如果没有，则不使用事务
    *         MANDATORY：该传播事务必须 存在一个事务，如果不存在则抛出异常
    *      REQUIRES_NEW：如果当前有事务，则会挂起该事务，自己创建一个新的事务供自己使用
    *                    如果当前没有事务，则同REQUIRED
    *     NOT_SUPPORTED：如果当前有事务，则把事务挂起，自己不使用事务去操作数据库
    *             NEVER：如果有事务，则抛出异常
    *            NESTED：如果当前有事务，则开启子事务（嵌套事务），嵌套事务是独立提交或者回滚的
    *                    如果没有事务，则同REQUIRED
    *                    但是如果主事务提交则子事务会一起提交
    *                    如果主事务回滚，则子事务会一起回滚，相反，子事务异常，父事务可以选择回滚或不回滚
    * */

    /*
    * ctrl +i 批量实现基类或接口中的方法
    * */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample=new Example(Users.class);
        Example.Criteria userCriteria=userExample.createCriteria();

        userCriteria.andEqualTo("username",username);
        Users result=usersMapper.selectOneByExample(userExample);
        return result==null?false:true;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username,String password) {
        Example userExample=new Example(Users.class);
        Example.Criteria userCriteria=userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        userCriteria.andEqualTo("password",password);
        Users result=usersMapper.selectOneByExample(userExample);
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        String userId=sid.nextShort();
        Users users=new Users();
        users.setId(userId);
        users.setUsername(userBO.getUsername());
        users.setPassword(MD5Utils.toMD5(userBO.getPassword()));
        users.setNickname(userBO.getUsername());
        users.setFace(USER_FACE);
        users.setBirthday(DateUtil.formatStringToDate("1900-01-01",false));
        users.setSex(Sex.secret.type);
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());

        usersMapper.insert(users);
        return users;
    }


}
