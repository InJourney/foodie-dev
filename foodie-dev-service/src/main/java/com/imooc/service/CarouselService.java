package com.imooc.service;

import com.imooc.pojo.Carousel;

import java.util.List;
/**
 * @description:
 * @auther ljt
 * @date 2021/2/22 10:42
 */
public interface CarouselService {

    /*
    * 查询所有轮播图列表
    * */
    public List<Carousel> queryAll(Integer isShow);

}
