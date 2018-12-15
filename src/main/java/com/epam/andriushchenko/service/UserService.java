package com.epam.andriushchenko.service;

import com.epam.andriushchenko.model.User;

public interface UserService {
    User getByLogin(User user);

    User getById(int id);
}
