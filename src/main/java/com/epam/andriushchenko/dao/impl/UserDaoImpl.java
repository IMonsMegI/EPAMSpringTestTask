package com.epam.andriushchenko.dao.impl;

import com.epam.andriushchenko.dao.UserDao;
import com.epam.andriushchenko.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class UserDaoImpl implements UserDao {
    @Inject
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public User getByLogin(User user) {
        Query<User> query = currentSession().createQuery("from User where login=:login and password=:password", User.class);
        query.setParameter("login", user.getLogin());
        query.setParameter("password", user.getPassword());
        return query.list().stream().findAny().orElse(null);
    }

    @Override
    public User getById(int id) {
        Query<User> query = currentSession().createQuery("from User where id= :id", User.class);
        query.setParameter("id", id);
        return query.list().stream().findAny().orElse(null);
    }
}
