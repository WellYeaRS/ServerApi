package com.springcloud.serverApi.vo;

/**
 * 数据返回实体
 * @param <T>
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public static Result success(){
        Result r = new Result();
        r.code = 0;
        r.msg = "成功";
        return r;
    }
    public static Result fail(String msg){
        Result r = new Result();
        r.code = -1;
        r.msg = msg;
        return r;
    }
}
