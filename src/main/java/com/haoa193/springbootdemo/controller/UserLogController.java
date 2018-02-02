package com.haoa193.springbootdemo.controller;


import com.haoa193.springbootdemo.model.Echo;
import com.haoa193.springbootdemo.model.Page;
import com.haoa193.springbootdemo.model.Result;
import com.haoa193.springbootdemo.model.query.UserLogQueryModel;
import com.haoa193.springbootdemo.service.UserLogService;
import com.haoa193.springbootdemo.vo.UserLogListVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author chenyongqdu@foxmail.com
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserLogController {

    @Autowired
    private UserLogService userLogService;

    @GetMapping("/user-logs")
    @ApiOperation(value = "echo service",notes = "echo", httpMethod = "GET")
    public Result<Page<UserLogListVo>> userLogs(UserLogQueryModel queryModel) {
        Page<UserLogListVo> page = userLogService.userLogs(queryModel);
        return Result.ok(page);
    }
}
