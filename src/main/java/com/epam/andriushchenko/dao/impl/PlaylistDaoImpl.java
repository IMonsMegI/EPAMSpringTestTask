package com.epam.andriushchenko.dao.impl;

import com.epam.andriushchenko.dao.PlaylistDao;
import com.epam.andriushchenko.model.Playlist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlaylistDaoImpl implements PlaylistDao {
    @Inject
    private SessionFactory sessionFactory;

    private Session createSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Playlist> getAll() {
        return createSession().createQuery("select playlists from Playlist playlists", Playlist.class).getResultList();
    }

    @Override
    public int add(String name, int userId) {
        Session session = createSession();
        session.getTransaction().begin();
        Query query = session.createNativeQuery("insert into playlists (name, countOfSongs, user) values(:name, 0, :userId)");
        query.setParameter("name", name);
        query.setParameter("userId", userId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public void delete(String name) {
        Session session = createSession();
        session.getTransaction().begin();
        Query query = session.createQuery("delete from Playlist where name = :name");
        query.setParameter("name", name);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public boolean isExist(String name) {
        Query<Playlist> query = createSession().createQuery("from Playlist where name=:name", Playlist.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findAny().orElse(null) != null;
    }

    @Override
    public Playlist getById(int playlistId) {
        Query<Playlist> query = createSession().createQuery("from Playlist where id= :playlistId", Playlist.class);
        query.setParameter("playlistId", playlistId);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
