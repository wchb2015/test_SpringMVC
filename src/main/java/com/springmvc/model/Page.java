package com.springmvc.model;

import java.util.List;

public class Page<T> implements java.io.Serializable {

    private static final long serialVersionUID = -3019215476521614796L;

    private long totalPage;//计算获得

    private long pageSize = 10;//默认是１０

    private long totalRecord;//构造参数

    private long pageNum;//构造参数

    private long startIndex;//计算获得

    private List<T> list;

    private long startPage;//计算获得

    private long endPage;//计算获得


    public Page(long pageNum, long totalRecord) {
        this.pageNum = pageNum;
        this.totalRecord = totalRecord;

        //算出总页数
        this.totalPage = (long) (this.totalRecord + this.pageSize - 1) / this.pageSize;
        //算出用户想看的页的数据从数据库哪个地方开始取
        this.startIndex = (this.pageNum - 1) * this.pageSize;

        if (this.totalPage <= 10) {
            this.startPage = 1;
            this.endPage = this.totalPage;
        } else {
            this.startPage = pageNum - 4;
            this.endPage = pageNum + 5;

            if (this.startPage < 1) {
                this.startPage = 1;
                this.endPage = 10;
            }

            if (this.endPage > this.totalPage) {
                this.endPage = this.totalPage;
                this.startPage = this.totalPage - 9;
            }
        }
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public long getStartPage() {
        return startPage;
    }

    public void setStartPage(long startPage) {
        this.startPage = startPage;
    }

    public long getEndPage() {
        return endPage;
    }

    public void setEndPage(long endPage) {
        this.endPage = endPage;
    }

}
