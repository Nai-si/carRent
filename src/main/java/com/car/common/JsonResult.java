package com.car.common;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/17 16:40
 * @Description:
 */
public class JsonResult {

    private int code;

    private Object info;//真正的返回到前端用的数据

    public JsonResult() {
    }

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", info=" + info +
                '}';
    }
}
