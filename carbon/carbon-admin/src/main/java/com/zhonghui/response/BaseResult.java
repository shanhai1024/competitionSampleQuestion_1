package com.zhonghui.response;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

//和以前唯一不一样的地方就是加了一个泛型T
@ApiModel("通用返回对象")  //注释这个类的信息
public class BaseResult<T> implements Serializable {
    //解释各字段的意思
    @ApiModelProperty(value= "返回码")
    private int code;
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "返回值")
    private T data;
    @ApiModelProperty(value = "总页数")
    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //几种构造方法
    public BaseResult() {
    }

    public BaseResult(Type type, String msg) {
        this.code = type.value;
        this.msg = msg;
    }

    public BaseResult(Type type, String msg, T data) {
        this.code = type.value;
        this.msg = msg;
        if (data != null) {
            this.data = data;
        }

    }
    public BaseResult(Type type, String msg, T data, Long total) {
        this.code = type.value;
        this.msg = msg;
        if (data != null) {
            this.data = data;
        }
        this.total = total;
    }

    // 分页返回方法
    public static <T> BaseResult<List<T>> success(List<T> data) {
        return BaseResult.success("操作成功", data, (new PageInfo(data)).getTotal());
    }


    public static <T> BaseResult<List<T>> success(String msg, List<T> data,Long total) {
        return new BaseResult(Type.SUCCESS, msg, data,total);
    }

    //静态方法要使用泛型参数的话，要声明其为泛型方法
    public static <T> BaseResult<T> success() {
        return success("操作成功");
    }

    public  static <T> BaseResult<T> success(T data) {
        return success("操作成功", data);
    }

    public static <T> BaseResult<T> success(String msg) {
        return success(msg, (T) null);
    }

    public static <T> BaseResult<T> success(String msg, T data) {
        return new BaseResult<T>(Type.SUCCESS, msg, data);
    }

    public static <T> BaseResult<T> warn(String msg) {
        return warn(msg, (T) null);
    }

    public static <T> BaseResult<T> warn(String msg, T data) {
        return new BaseResult<T>(Type.WARN, msg, data);
    }


    public static <T> BaseResult<T> unAuth() {
        return new BaseResult<T>(Type.UNAUTH, "未登陆", (T)null);
    }

    public static <T> BaseResult<T> error() {
        return error("操作失败");
    }

    public static <T> BaseResult<T> error(String msg) {
        return error(msg, (T)null);
    }

    public static <T> BaseResult<T> error(String msg, T data) {
        return new BaseResult<T>(Type.ERROR, msg, data);
    }

    public static enum Type {
        SUCCESS(200),
        WARN(402),
        UNAUTH(401),
        ERROR(500);

        private final int value;

        private Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
