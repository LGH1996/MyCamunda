package com.example.mycamunda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@Slf4j
@RequestMapping("/lgh")
public class MyController {

    @Resource
    DataSource dataSource;

    @GetMapping("/message")
    public Object message() {
        log.info(dataSource.toString());
        return dataSource.getClass().getSimpleName();
    }
}
