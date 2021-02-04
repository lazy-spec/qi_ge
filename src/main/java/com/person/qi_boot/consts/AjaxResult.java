package com.person.qi_boot.consts;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AjaxResult {

    private Integer code;
    private String msg;
    private Map<String, Object> data = new HashMap<>();

    private AjaxResult(){}

    public static AjaxResult ok() {
        AjaxResult result = new AjaxResult();
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }

    public static AjaxResult fail() {
        AjaxResult result = new AjaxResult();
        result.setCode(500);
        result.setMsg("请求失败");
        return result;
    }

    public AjaxResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    public AjaxResult msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public AjaxResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public AjaxResult data(Map<String, Object> data) {
        this.data = data;
        return this;
    }

}
