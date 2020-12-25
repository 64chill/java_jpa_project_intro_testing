package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SUBGROUPS")
public class SubGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="subname")
    private String subname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idChat")
    private ChatRoom idChatRoom;

    public SubGroup(){}

    public SubGroup(String subname, ChatRoom idChatRoom) {
        this.subname = subname;
        this.idChatRoom = idChatRoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public ChatRoom getIdChatRoom() {
        return idChatRoom;
    }

    public void setIdChatRoom(ChatRoom idChatRoom) {
        this.idChatRoom = idChatRoom;
    }

    @Override
    public String toString() {
        return "SubGroup{" +
                "id=" + id +
                ", subname='" + subname + '\'' +
                ", idChatRoom=" + idChatRoom +
                '}';
    }
}
