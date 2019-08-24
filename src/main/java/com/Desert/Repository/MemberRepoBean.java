package com.Desert.Repository;

import com.Desert.Entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepoBean implements MemberRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Member getMemberByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.bySimpleNaturalId(Member.class).load(email);
    }

    @Override
    public void insertMember(Member member) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(member);
    }

    @Override
    public Member getMemberByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Member> query = session.createQuery("FROM Member m WHERE m.username = ?1", Member.class);
        query.setParameter(1, username);
        return query.getSingleResult();
    }

    @Override
    public void updateMemberByUsername(Member member) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(member);
    }

    @Override
    public boolean existedEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Member> query = session.createQuery("FROM Member m WHERE m.email = ?1", Member.class);
        query.setParameter(1, email);
        return query.getResultList().size() == 1;
    }

    @Override
    public boolean existedUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Member> query = session.createQuery("FROM Member m WHERE m.username = ?1", Member.class);
        query.setParameter(1, username);
        return query.getResultList().size() == 1;
    }
}
