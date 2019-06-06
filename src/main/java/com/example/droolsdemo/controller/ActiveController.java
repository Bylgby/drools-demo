package com.example.droolsdemo.controller;

import com.example.droolsdemo.entity.PointDomain;
import com.example.droolsdemo.service.PointRuleEngine;
import com.example.droolsdemo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 规则引擎demo
 * @Author maxiaowei
 * @create 2019/2/18 11:26
 * @Version 1.0
 **/
@RestController
public class ActiveController {

    @Autowired
    PointRuleEngine pointRuleEngine;

    @PostMapping(value = "drools/test")
    public R test(){
        PointDomain pointDomain = new PointDomain();
        pointDomain.setBirthday(true);
        pointDomain.setPoint(10L);
        pointDomain.setUsername("小明");
        pointDomain.setBackNums(1);
        pointDomain.setBuyNums(6);
        pointDomain.setBuyMoney(1000.5);
        return pointRuleEngine.excuteRuleEngin(pointDomain);
    }
}
