package com.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="DIRECTCHAT")
@NamedQuery(name="DirectChat.findAll", query="SELECT c FROM DirectChat c")
public class DirectChat extends Chat { ;

    public DirectChat(){}

    public DirectChat(Integer postedBy, String msg, Date date, Boolean active) {
        super(postedBy, msg, date, active);
    }
}
