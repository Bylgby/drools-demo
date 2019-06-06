package com.example.droolsdemo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description  积分计算对象
 * @Author maxiaowei
 * @create 2019/2/18 14:41
 * @Version 1.0
 **/
public class PointDomain {

    private Logger logger = LoggerFactory.getLogger(PointDomain.class);
    /**
     * 用户名
     */
    private String username;

    /**
     * 是否生日
     */
    private Boolean isBirthday;

    /**
     * 积分增加数目
     */
    private Long point;

    /**
     * 当月购物次数
     */
    private Integer buyNums;

    /**
     * 当月退货次数
     */
    private Integer backNums;

    /**
     * 当月购物总金额
     */
    private Double buyMoney;

    /**
     * 当月退货总金额
     */
    private Double backMoney;

    /**
     * 当月还款次数
     */
    private Integer repaymentNums;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getBirthday() {
        return isBirthday;
    }

    public void setBirthday(Boolean birthday) {
        isBirthday = birthday;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Integer getBuyNums() {
        return buyNums;
    }

    public void setBuyNums(Integer buyNums) {
        this.buyNums = buyNums;
    }

    public Integer getBackNums() {
        return backNums;
    }

    public void setBackNums(Integer backNums) {
        this.backNums = backNums;
    }

    public Double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(Double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Double getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(Double backMoney) {
        this.backMoney = backMoney;
    }

    public Integer getRepaymentNums() {
        return repaymentNums;
    }

    public void setRepaymentNums(Integer repaymentNums) {
        this.repaymentNums = repaymentNums;
    }

    
    /**
     * @Description 记录积分发放流水，防止重复发放
     * @Date  2019/2/18 14:49 
     * @Param 
     * @return 
     * @Author maxiaowei
     **/
    public void recordPointLog(String username,String type, int scope){
        logger.info("增加对{}的类型为{}的积分操作记录,积分增加{}",username,type,scope);
    }
}
