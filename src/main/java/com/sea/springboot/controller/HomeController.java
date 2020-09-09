package com.sea.springboot.controller;

import com.sea.springboot.entity.User;
import com.sea.springboot.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("home")
@Api(tags = "用户操作接口")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("test")
    @ApiOperation("添加用户的接口")
    public List<User> test() {
        return homeService.test();
    }

    @GetMapping("error")
    @ApiOperation("报错")
    public void error() {
        throw new RuntimeException("报错了！");
    }

}
