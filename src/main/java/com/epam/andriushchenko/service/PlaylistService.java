package com.epam.andriushchenko.service;

import com.epam.andriushchenko.model.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getAll();

    boolean add(String name, int userId);

    void delete(String name);

    boolean isExist(String name);

    Playlist getById(int playlistId);
}
