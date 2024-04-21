package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
public class User implements Serializable {
    private  Integer id;

    @NotEmpty(message = "用户名不能为空！")
    private String username;

    @NotEmpty(message = "密码不能为空！")
    @Size(min = 8, message = "密码长度不能小于8！")
    private String password;
    /**
     * {@code @role} == 1  teacher
     * 2  == student
     */
    private Integer role;
}
