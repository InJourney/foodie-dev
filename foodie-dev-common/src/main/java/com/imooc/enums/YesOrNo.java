package com.imooc.enums;

/**
 * @description: 性别枚举
 * @auther ljt
 * @date 2021/2/25 15:05
 */
public enum YesOrNo {
    NO(0,"否"),
    YES(1,"是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value){
        this.type=type;
        this.value=value;
    }
}
