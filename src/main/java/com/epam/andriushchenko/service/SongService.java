package com.epam.andriushchenko.service;

import com.epam.andriushchenko.model.Song;

import java.util.List;

public interface SongService {
    List<Song> getAll();

    void addToPlaylist(int playlistId, int songId);

    List<Song> getAllFromPlaylist(int playlistId);
}
