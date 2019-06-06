package com.example.droolsdemo.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Project : linkedhu-core
 * @Program Name : com.linkedhu.common.utils.R.java
 * @Description : 返回数据
 * @Author : chutong
 * @Creation Date : 2018年7月11日 下午4:00:00
 * @ModificationHistory Who When What ---------- ------------- -----------------------------------
 *                      chutong 2018年7月11日 create
 */
public class R implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 状态
     */
    private int status;
    /**
     * 错误代码
     */
    private int code;
    /**
     * 消息提示
     */
    private String msg;
    /**
     * 内容
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    public R() {
        this.status = 0;
        this.code = 0;
        this.msg = "success";
    }

    public static R error() {
        return error(500, "未知异常，请联系客服");
    }

    public static R error(String msg) {
        return error(401, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.setStatus(-1);
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.setMsg(msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.setData(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
