package com.itony.safetyedu.ctools;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
//定义具体的数据返回格式
@Data
public class R1 {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<>();
    private R1(){}

    //操作成功，调用这个方法，返回成功的数据
    public static R1 ok(){
        R1 r = new R1();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("操作成功");
        return r;
    }

    //操作失败，调用这个方法，返回失败的数据
    public static R1 error(){
        R1 r = new R1();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("操作失败");
        return r;
    }

    //使用链式编程
    public R1 success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R1 message(String message){
        this.setMessage(message);
        return this;
    }

    public R1 code(Integer code){
        this.setCode(code);
        return this;
    }

    public R1 data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R1 data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
