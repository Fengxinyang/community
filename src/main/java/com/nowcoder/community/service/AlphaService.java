package com.nowcoder.community.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class AlphaService {

    public AlphaService(){
        System.out.println("实例化了service");
    }

    @PostConstruct
    public void hello(){
        System.out.println("初始化了service");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁了service");
    }


}
