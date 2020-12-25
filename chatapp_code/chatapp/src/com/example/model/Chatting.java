package com.example.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CHATTING")
public class Chatting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idChatting")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccount")
    private Account account; //id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idChat")
    private Chat chat; //id

    public Chatting(){}

    public Chatting(Account account, Chat chat) {
        this.account = account;
        this.chat = chat;
    }


    @Override
    public String toString() {
        return "Chatting{" +
                "id=" + id +
                ", account=" + account +
                ", chat=" + chat +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
