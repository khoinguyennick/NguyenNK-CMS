package com.Desert.Repository;

import com.Desert.Entity.Content;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentRepoBean implements ContentRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Content> getContentListOfAuthor(long authorID) {
        Session session = sessionFactory.getCurrentSession();
        Query<Content> query = session.createQuery("FROM Content c WHERE c.authorID = ?1", Content.class);
        query.setParameter(1, authorID);
        return query.getResultList();
    }

    @Override
    public List<Content> searchContent(long authorID, String keyword) {
        Session session = sessionFactory.getCurrentSession();
        Query<Content> query = session.createQuery("FROM Content c WHERE c.authorID = ?1 " +
                "AND (c.title LIKE ?2 OR c.brief LIKE ?3)", Content.class);
        query.setParameter(1, authorID);
        query.setParameter(2, "%" + keyword + "%");
        query.setParameter(3, "%" + keyword + "%");

        return query.getResultList();
    }

    @Override
    public void insertContent(Content content) {
        Session session = sessionFactory.getCurrentSession();
        session.save(content);
    }

    @Override
    public boolean existedTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query<Content> query = session.createQuery("FROM Content WHERE title = ?1", Content.class);
        query.setParameter(1, title);
        return query.getResultList().size() == 1;
    }
}
