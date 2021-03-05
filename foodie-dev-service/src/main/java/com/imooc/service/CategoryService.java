package com.imooc.service;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;

import java.util.List;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/22 10:42
 */
public interface CategoryService {

    /*
    * 查询所有一级分类
    * */
    public List<Category> queryAllRootLevelCat();

}
