package com.epam.andriushchenko.service.impl;

import com.epam.andriushchenko.dao.PlaylistDao;
import com.epam.andriushchenko.model.Playlist;
import com.epam.andriushchenko.service.PlaylistService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Inject
    private PlaylistDao playlistDao;

    @Override
    public List<Playlist> getAll() {
        return playlistDao.getAll();
    }

    @Override
    public boolean add(String name, int userId) {
        return playlistDao.add(name, userId) > 0;
    }

    @Override
    public void delete(String name) {
        playlistDao.delete(name);
    }

    @Override
    public boolean isExist(String name) {
        return playlistDao.isExist(name);
    }

    @Override
    public Playlist getById(int playlistId) {
        return playlistDao.getById(playlistId);
    }
}
