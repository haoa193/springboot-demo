package com.haoa193.springbootdemo.controller;

import com.haoa193.springbootdemo.model.Echo;
import com.haoa193.springbootdemo.model.Result;
import com.haoa193.springbootdemo.service.EchoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EchoController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/echo")
    @ApiOperation(value = "echo service",notes = "echo", httpMethod = "GET")
    public Result<Echo> echo(@RequestParam String echo) {
        Echo e = echoService.echo(echo);
        e.setEcho("echo " + echo);
        return Result.ok(e);
    }
}
