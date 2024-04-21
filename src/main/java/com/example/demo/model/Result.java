package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @param <T>数据类型
 */
@Data
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
public class Result<T> implements Serializable {

    /**
     * 消息
     */
    private String message;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回数据主体
     */
    private  T data;

    /**
     * 设定结果为成功
     *
     * @param msg 消息
     */
    public void setResultSuccess(String msg) {
        this.message = msg;
        this.success = true;
        this.data = null;
    }

    /**
     * 设定结果为成功
     *
     * @param msg  消息
     * @param data 数据体
     */
    public void setResultSuccess(String msg, T data) {
        this.message = msg;
        this.success = true;
        this.data = data;
    }

    /**
     * 设定结果为失败
     *
     * @param msg 消息
     */
    public void setResultFailed(String msg) {
        this.message = msg;
        this.success = false;
        this.data = null;
    }
}
