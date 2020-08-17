package com.sea.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("home")
@Api(tags = "用户操作接口")
public class HomeController {

    @GetMapping("test")
    @ApiOperation("添加用户的接口")
    public String test() {
        return "hello world!";
    }

    @GetMapping("error")
    @ApiOperation("报错")
    public void error() {
        throw new RuntimeException("报错了！");
    }

}
