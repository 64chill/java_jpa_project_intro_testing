package com.example.ui;

import com.example.model.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chat_nsi");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        setDataToOurDB(em,tx);

        //TypedQuery
        System.out.println("Typed Query");
        TypedQuery<Account> q1 = em.createQuery("SELECT c FROM Account c", Account.class);
        System.out.println(q1.getResultList());

        // NamedQuery
        TypedQuery<DirectChat> q2 = em.createNamedQuery("DirectChat.findAll", DirectChat.class);
        System.out.println("---");
        System.out.println("NamedQuery");
        System.out.println(q2.getResultList());

        // NamedQueries

        //1
        TypedQuery<Account> q3 = em.createNamedQuery("Account.findByActive", Account.class);
        q3.setParameter("active", true);
        System.out.println("---");
        System.out.println("NamedQueries 1");
        System.out.println(q3.getResultList());

        //2
        TypedQuery<Account> q4 = em.createNamedQuery("Account.findByUserName", Account.class);
        q4.setParameter("username", "aaa0");
        System.out.println("---");
        System.out.println("NamedQueries 2");
        System.out.println(q4.getResultList());

        //3
        TypedQuery<Account> q5 = em.createNamedQuery("Account.activeCount", Account.class);
        System.out.println("---");
        System.out.println("NamedQueries 3");
        System.out.println(q5.getResultList());
        System.out.println("*****************");

        // Criteria API
        System.out.println("---");
        System.out.println("Criteria API");

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(Chat.class);
        cq.where(cb.equal(e.get("idChat"), cb.parameter(Long.class, "idChat")));
        Query query = em.createQuery(cq);
        query.setParameter("idChat", 7);
        Chat res = (Chat)query.getSingleResult();
        System.out.println(res);

        // Ssmall Complicated Query
        //1
        System.out.println("---");
        System.out.println("Complicated Query 1");
        Long msgNum = (Long) em.createQuery("SELECT COUNT(ch.msg) FROM Chatting cht " +
                        "JOIN cht.account a JOIN cht.chat ch"+
                        " WHERE a.username = 'asd123'   ")
                        .getSingleResult();
        System.out.println(msgNum);

        System.out.println("---");
        System.out.println("Complicated Query  2");

        List<ChattingRomInfo> aml = em.createQuery("SELECT new com.example.model.ChattingRomInfo(chr.msg, chr.date, sb.subname)"+
                "FROM ChatRoom chr JOIN chr.subGroups sb WHERE chr.date > '1900-12-12' ").getResultList();
        System.out.println(aml);
        aml.forEach(System.out::println);

        em.close();
    }

    public static void setDataToOurDB(EntityManager em, EntityTransaction tx ){
        // account
        tx.begin();
        ArrayList<Account> accL = new ArrayList();

        for (int i = 0; i < 5 ; i++) {
            Account acc = new Account("aaa"+ i +"@aaa.com", "aaa"+i, "secret", true);
            em.persist(acc);
            accL.add(acc);
        }

        //direct-chat
        DirectChat dc = new DirectChat(1,"Hello World!",new Date(158), true);
        em.persist(dc);

        //chat-room
        //Integer postedBy, String msg, Date date, Boolean active, String cname, String crddesc, List<SubGroup> subGroups
        ArrayList<SubGroup> subl1 = new ArrayList<>();
        ArrayList<SubGroup> subl2 = new ArrayList<>();
        ChatRoom cr1 = new ChatRoom(2, "asasdsadsa", new Date(181), true, "cname1", "cdesc1", subl1);
        ChatRoom cr2 = new ChatRoom(3, "qwewqewqewq", new Date(181), true, "cname1", "cdesc1", subl2);

        //chatting 1,2,3

        //sub-groups
        SubGroup sub1 = new SubGroup("1st", cr1 );
        SubGroup sub2 = new SubGroup("2st", cr2 );
        subl1.add(sub1);
        subl2.add(sub2);

        cr1.setSubGroups(subl1);
        cr2.setSubGroups(subl2);

        em.persist(cr1);
        em.persist(cr2);
        em.persist(sub1);

        //chatting
        em.persist(new Chatting(accL.get(0) , dc));

        em.persist(sub1);
        em.persist(sub2);

        em.persist(new Chatting(accL.get(1) , cr1));
        em.persist(new Chatting(accL.get(2) , cr1));
        em.persist(new Chatting(accL.get(3) , cr1));

        em.persist(new Chatting(accL.get(1) , cr2));
        em.persist(new Chatting(accL.get(2) , cr2));
        em.persist(new Chatting(accL.get(3) , cr2));

        tx.commit();
    }
}
