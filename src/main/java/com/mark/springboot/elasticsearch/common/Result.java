package com.mark.springboot.elasticsearch.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4505655308965878999L;

    /**
     *  请求成功返回码为：0-成功
     */
    private static final Integer SUCCESS_CODE = 0;

    /**
     *  请求成功信息
     */
    private static final String SUCCESS_MSG = "REQUEST SUCCESS";

    /**
     *  请求成功返回码为：-1-失败
     */
    private static final Integer FAIL_CODE = -1;

    /**
     *  请求失败信息
     */
    private static final String FAIL_MSG = "REQUEST FAIL";
    /**
     *  返回数据
     */
    private T data;
    /**
     *  返回码
     */
    private int code;

    /**
     *  返回描述
     */
    private String msg;

    private boolean status=true;

    public Result() {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
    }

    public Result(boolean status, int code) {
        this();
        this.status=status;
        this.code = code;
    }

    public Result(int code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    public Result(boolean status, int code, String msg) {
        this();
        this.status=status;
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(boolean status, int code, String msg, T data) {
        this();
        this.status=status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(T data) {
        this();
        this.data = data;
    }

    public static Result<Object> successData(Object data) {
        Result result = new Result(SUCCESS_CODE, SUCCESS_MSG, data);
        return result;
    }

    public static Result<Object> failData(Object data) {
        Result result = new Result(FAIL_CODE, FAIL_MSG, data);
        return result;
    }
}
