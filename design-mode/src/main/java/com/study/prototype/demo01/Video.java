package com.study.prototype.demo01;


import java.util.Date;

/**
 * 实现一个接口 Cloneable
 * 重写一个方法  clone()
 */

public class Video implements Cloneable{
    private String name;
    private Date CreateTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Video() {
    }

    public Video(String name, Date createTime) {
        this.name = name;
        CreateTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
