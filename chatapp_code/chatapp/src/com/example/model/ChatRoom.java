package com.example.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="CHATROOM")
public class ChatRoom extends Chat {

    @Column(name="cname")
    private String cname;

    @Column(name="crddesc")
    private String crddesc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="idChatRoom")
    private List<SubGroup> subGroups;

    public ChatRoom(Integer postedBy, String msg, Date date, Boolean active, String cname, String crddesc, List<SubGroup> subGroups) {
        super(postedBy, msg, date, active);
        this.cname = cname;
        this.crddesc = crddesc;
        this.subGroups = subGroups;
    }

    public ChatRoom(){}

    public ChatRoom(String cname, String crddesc, List<SubGroup> subGroups) {
        this.cname = cname;
        this.crddesc = crddesc;
        this.subGroups = subGroups;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCrddesc() {
        return crddesc;
    }

    public void setCrddesc(String crddesc) {
        this.crddesc = crddesc;
    }

    public List<SubGroup> getSubGroups() {
        return subGroups;
    }

    public void setSubGroups(List<SubGroup> subGroups) {
        this.subGroups = subGroups;
    }
}
