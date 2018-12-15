package com.epam.andriushchenko.dao;

import com.epam.andriushchenko.model.Playlist;

import java.util.List;

public interface PlaylistDao {
    List<Playlist> getAll();

    int add(String name, int userId);

    void delete(String name);

    boolean isExist(String name);

    Playlist getById(int playlistId);
}
