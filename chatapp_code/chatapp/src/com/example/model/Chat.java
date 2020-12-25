package com.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="CHAT")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Chat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idChat")
    private Integer idChat;

    @Column(name="postedBy")
    private Integer postedBy;// idAccount;

    @Column(name="msg")
    private String msg;

    @Column(name="date")
    private Date date;

    @Column(name="active")
    private Boolean active;

    public Chat(){}

    public Chat(Integer postedBy, String msg, Date date, Boolean active) {
        this.postedBy = postedBy;
        this.msg = msg;
        this.date = date;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "idChat=" + idChat +
                ", postedBy='" + postedBy + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                ", active=" + active +
                '}';
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Integer getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Integer postedBy) {
        this.postedBy = postedBy;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
