package com.example.droolsdemo.service;

import com.example.droolsdemo.entity.PointDomain;
import com.example.droolsdemo.util.R;

/**
 * @Description 积分规则接口
 * @Author maxiaowei
 * @create 2019/2/18 14:51
 * @Version 1.0
 **/
public interface PointRuleEngine {

    /**
     * 初始化规则引擎
     */
    public void initEngin();

    /**
     * 刷新引擎中的规则
     */
    public void refreshEnginRule();


    /**
     * @Description  执行规则
     * @Date  2019/2/18 14:59
     * @Param PointDomain 积分计算对象
     * @return
     * @Author maxiaowei
     **/
    public R excuteRuleEngin(final PointDomain pointDomain);
}
