package com.springmvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@ToString
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = -1339779207837058584L;

    private Long count;
    private Collection<T> list;

    public PageData(Long count, Collection<T> list) {
        this.count = count;
        this.list = list;
    }

}
