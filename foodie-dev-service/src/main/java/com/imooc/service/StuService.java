package com.imooc.service;

import com.imooc.pojo.Stu;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/22 10:42
 */
public interface StuService {
    public Stu getStuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);
}
