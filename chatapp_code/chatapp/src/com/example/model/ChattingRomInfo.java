package com.example.model;

import java.sql.Date;

public class ChattingRomInfo {
    private String msg;
    private Date date;
    private String subname;

    public ChattingRomInfo() {
    }

    public ChattingRomInfo(String msg, Date date, String subname) {
        this.msg = msg;
        this.crname = crname;
        this.desc = desc;
        this.date = date;
        this.subname = subname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    @Override
    public String toString() {
        return "ChattingRomInfo{" +
                "msg='" + msg + '\'' +
                ", date=" + date +
                ", subname='" + subname + '\'' +
                '}';
    }
}