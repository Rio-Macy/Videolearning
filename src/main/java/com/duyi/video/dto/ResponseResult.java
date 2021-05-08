package com.duyi.video.dto;

/**
 * @author sujuntao
 */
public class ResponseResult<T> {

    /** code
     *  1：表示成功
     *  0：表示失败
     *  3：不合法
     */
    private int code;
    /**
     *  message:描述字符串的内容
     *  1：email可以使用
     *  0：email已经被占用
     *  3：用户不合法
     */
    private String message;

    /**
     *  存储的数据
     */
    private T data;

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public ResponseResult() {
    }

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
