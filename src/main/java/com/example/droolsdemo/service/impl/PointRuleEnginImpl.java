package com.example.droolsdemo.service.impl;

import com.example.droolsdemo.Enum.RulesEnums;
import com.example.droolsdemo.entity.PointDomain;
import com.example.droolsdemo.service.PointRuleEngine;
import com.example.droolsdemo.util.DroolsUtil;
import com.example.droolsdemo.util.R;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @Description  规则实现类
 * @Author maxiaowei
 * @create 2019/2/18 15:00
 * @Version 1.0
 **/
@Service
public class PointRuleEnginImpl implements PointRuleEngine {

    @Autowired
    Map<String,KieSession> kieSessionMap;

    /**
     * 初始化规则引擎
     */
    @Override
    public void initEngin() {
        //首先设置时间格式
    }

    /**
     * 刷新引擎中的规则
     */
    @Override
    public void refreshEnginRule() {

    }

    /**
     * @param pointDomain
     * @return
     * @Description 执行规则
     * @Date 2019/2/18 14:59
     * @Param PointDomain 积分计算对象
     * @Author maxiaowei
     */
    @Override
    public R excuteRuleEngin(PointDomain pointDomain) {

        R r = new R();
        r = DroolsUtil.executeRule(kieSessionMap.get(RulesEnums.rule1.name),pointDomain,r);
//        DroolsUtil.executeRule(kieSessionMap.get(RulesEnums.rule2),pointDomain);
        System.out.println(r.getCode());

//        Integer[] arr = new Integer[10];
//
//        Arrays.sort(arr, ( o1, o2) -> Integer.compare(o2,o1));

        return r.put("scope",pointDomain.getPoint());
    }
}
