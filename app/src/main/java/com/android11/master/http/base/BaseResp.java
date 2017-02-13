package com.android11.master.http.base;

/**
 * 返回数据基类
 *
 * @author 周康
 */
public class BaseResp<T> {
    private int resultCode;
    private String errMsg;
    private T data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errmsg) {
        this.errMsg = errmsg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
