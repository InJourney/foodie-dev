package com.imooc.service.impl;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/22 10:45
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveStu() {

    }

    @Override
    public void updateStu(int id) {

    }

    @Override
    public void deleteStu(int id) {

    }
}
