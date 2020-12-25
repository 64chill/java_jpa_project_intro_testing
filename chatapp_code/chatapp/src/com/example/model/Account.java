package com.example.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ACCOUNT")
@NamedQueries({
        @NamedQuery(name="Account.findByActive",
                query="SELECT c FROM Account c where c.active = :active"),
        @NamedQuery(name="Account.activeCount",
                query="SELECT count(c) FROM Account c WHERE c.active = true"),
        @NamedQuery(name="Account.findByUserName",
                query="SELECT c FROM Account c WHERE c.username = :username"),
})
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idAccount")
    private Integer idAccount;

    @Column(name="uemail")
    private String uemail;

    @Column(name="username")
    private String username;

    @Column(name="pwd")
    private String pwd;

    @Column(name="active")
    private Boolean active;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "idChatting")
    //private List<Chatting> chattingList;

    public Account(){}


    public Account(String uemail, String username, String pwd, Boolean active) {
        this.uemail = uemail;
        this.username = username;
        this.pwd = pwd;
        this.active = active;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", uemail='" + uemail + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", active=" + active +
                '}';
    }
}
