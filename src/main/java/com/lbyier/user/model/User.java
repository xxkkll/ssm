package com.lbyier.user.model;

import java.io.Serializable;

/**
 * @author LByier
 * @date 2020/10/9 15:01
 */

public class User implements Serializable {


    private String stuName;

    private String stuNum;

    private String stuPwd;

    private Integer id;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", id=" + id +
                '}';
    }
}
