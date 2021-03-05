package com.imooc.controller;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/18 17:42
 */
//@Controller
@ApiIgnore
@RestController
public class HelloController {

    final static Logger logger=LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Object hello(){
        logger.debug("debug:hello~");
        logger.info("info:hello~");
        logger.error("error:hello~");
        logger.warn("warn:hello~");
        return "Hello World~";
    }
}
