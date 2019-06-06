package com.example.droolsdemo.Enum;

/**
 * @Description     规则枚举
 * @Author maxiaowei
 * @create 2019/2/18 18:02
 * @Version 1.0
 **/
public enum RulesEnums {

    rule1("testRule","rules/test/");
//    rule2("subpoint","rules/old/");

    public String name;
    public String path;

    RulesEnums(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
