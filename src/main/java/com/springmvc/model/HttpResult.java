package com.springmvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpResult<E> {

    private Integer code;
    private String msg;
    private E data;

    public HttpResult(Integer code, E data) {
        this.code = code;
        this.data = data;
    }

    public static <E> HttpResult<E> success(E data) {
        return new HttpResult<E>(200, data);
    }
}
