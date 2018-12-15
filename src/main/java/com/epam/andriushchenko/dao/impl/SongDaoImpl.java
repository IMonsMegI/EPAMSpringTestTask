package com.epam.andriushchenko.dao.impl;

import com.epam.andriushchenko.dao.SongDao;
import com.epam.andriushchenko.model.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class SongDaoImpl implements SongDao {
    @Inject
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Song> getAll() {
        return currentSession().createQuery("select songs from Song songs", Song.class).getResultList();
    }

    @Override
    public void addToPlaylist(int playlistId, int songId) {
        Session session = currentSession();
        session.getTransaction().begin();
        Query songsPlaylistQuery = session.createNativeQuery("insert into songs_playlists (song_id, playlist_id) values (:songId, :playlistId)");
        songsPlaylistQuery.setParameter("songId", songId);
        songsPlaylistQuery.setParameter("playlistId", playlistId);
        songsPlaylistQuery.executeUpdate();
        Query playlistCountOfSongsIncrementQuery = session.createQuery("update Playlist set countOfSongs=countOfSongs+1");
        playlistCountOfSongsIncrementQuery.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public List<Song> getAllFromPlaylist(int playlistId) {
        Query<Song> query = currentSession()
                .createNativeQuery("select * from songs where id in (select song_id from songs_playlists where playlist_id= :playlistId)", Song.class);
        query.setParameter("playlistId", playlistId);
        return query.getResultList();
    }
}
