package com.example.droolsdemo.util;

import com.example.droolsdemo.entity.PointDomain;
import org.kie.api.runtime.KieSession;

import java.sql.SQLOutput;

/**
 * @Description  drools工具类
 * @Author maxiaowei
 * @create 2019/2/18 17:54
 * @Version 1.0
 **/
public class DroolsUtil {

    public synchronized static R executeRule(KieSession kieSession, PointDomain pointDomain, R r){
        if (null != pointDomain){
            kieSession.insert(pointDomain);
            kieSession.insert(r);
            int count = kieSession.fireAllRules();
            System.out.println("执行完毕！");
        }
        return r;
    }
}
