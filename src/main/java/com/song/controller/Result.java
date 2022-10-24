package com.song.controller;

public class Result<T> {
    private Integer code;
    private T data;
    private String msg;


    public Result() {
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }


    public Result(T data){
        this.data = data;
    }
    public Result(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static <T> Result<T> success(T  data){

        Result<T> result = new Result<>(data);
        result.setCode(Code.GET_OK);
        result.setMsg("请求成功");
        return result;
    }
}
