package com.yodata.core.domain;

import java.util.List;

/** 这个对象主要用于分页
 * 同时默认第一页的Index从1开始
 * 这个对象格式化成JSON就是前台二维表的格式
 * Created by zheng.liu@baifendian on 2015-07-09.
 */
public class Page<T> {
    private int current;
    private int count;
    private int countPerPage;
    private List<T> date;

    public Page() {
        current=1;
        countPerPage=10;
    }

    public Page(int current, int count, int countPerPage) {
        this.current = current;
        this.count = count;
        this.countPerPage = countPerPage;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(int countPerPage) {
        this.countPerPage = countPerPage;
    }

    public List<T> getDate() {
        return date;
    }

    public void setDate(List<T> date) {
        this.date = date;
    }
}
