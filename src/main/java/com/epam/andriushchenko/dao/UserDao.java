package com.epam.andriushchenko.dao;

import com.epam.andriushchenko.model.User;

public interface UserDao {
    User getByLogin(User user);

    User getById(int id);
}
