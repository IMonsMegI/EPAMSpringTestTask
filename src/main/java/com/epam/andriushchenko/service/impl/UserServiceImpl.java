package com.epam.andriushchenko.service.impl;

import com.epam.andriushchenko.dao.UserDao;
import com.epam.andriushchenko.model.User;
import com.epam.andriushchenko.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User getByLogin(User user) {
        return userDao.getByLogin(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
