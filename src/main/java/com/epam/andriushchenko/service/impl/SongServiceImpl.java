package com.epam.andriushchenko.service.impl;

import com.epam.andriushchenko.dao.SongDao;
import com.epam.andriushchenko.model.Song;
import com.epam.andriushchenko.service.SongService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Inject
    private SongDao songDao;

    @Override
    public List<Song> getAll() {
        return songDao.getAll();
    }

    @Override
    public void addToPlaylist(int playlistId, int songId) {
        songDao.addToPlaylist(playlistId, songId);
    }

    @Override
    public List<Song> getAllFromPlaylist(int playlistId) {
        return songDao.getAllFromPlaylist(playlistId);
    }
}
