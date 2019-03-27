package com.aijuke.hpface.entity;

import com.aijuke.hpface.common.SysConstant;
import lombok.Data;

import java.util.Collections;

@Data
public class ResultEntity {

    private String result;
    private Integer rescode;
    private String msg;
    private Object data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getRescode() {
        return rescode;
    }

    public void setRescode(Integer rescode) {
        this.rescode = rescode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultEntity success() {
        return create(true, SysConstant.getRescodeOk(), "操作成功", Collections.emptyMap());
    }

    public static ResultEntity success(Object object) {
        return create(true, SysConstant.getRescodeOk(), "操作成功", object);
    }

    public static ResultEntity fail(String errorMsg) {
        return create(false, SysConstant.getRescodeFail(), errorMsg, Collections.emptyMap());
    }

    public static ResultEntity unauthorized(String errorMsg) {
        return create(false, SysConstant.getUnauthorized(), errorMsg, Collections.emptyMap());
    }

    public static ResultEntity fail(String errorMsg, Object obj) {
        return create(false, SysConstant.getRescodeFail(), errorMsg, obj);
    }

    private static ResultEntity create(boolean isOk, int resCode, String errorMsg, Object obj) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.msg = errorMsg;
        resultEntity.rescode = resCode;
        resultEntity.result = isOk ? "ok" : "fail";
        resultEntity.data = obj;
        return resultEntity;
    }
}
