package com.xinyan.boot.exception;

/**
 * @author 孟星魂
 * @version 5.0 createTime: 2019/8/20
 */
public class MyException extends RuntimeException {
    private String code;
    private String resMessage;

    public MyException(String code, String message) {
        super(message);
        this.code = code;
        this.resMessage = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getResMessage() {
        return this.resMessage;
    }
}
