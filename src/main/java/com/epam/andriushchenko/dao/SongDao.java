package com.epam.andriushchenko.dao;

import com.epam.andriushchenko.model.Song;

import java.util.List;

public interface SongDao {
    List<Song> getAll();

    void addToPlaylist(int playlistId, int songId);

    List<Song> getAllFromPlaylist(int playlistId);
}
