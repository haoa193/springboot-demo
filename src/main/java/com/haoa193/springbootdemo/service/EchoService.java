package com.haoa193.springbootdemo.service;

import com.haoa193.springbootdemo.model.Echo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EchoService {
    public Echo echo(String echo) {
        log.debug("echo: {}", echo);
        return Echo.builder().echo(echo).build();
    }
}
