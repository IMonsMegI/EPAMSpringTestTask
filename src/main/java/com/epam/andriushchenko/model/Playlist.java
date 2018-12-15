package com.epam.andriushchenko.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private int countOfSongs;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", nullable = false)
    private User user;
    @ManyToMany(mappedBy = "playlistsWithThisSong")
    private Set<Song> songsInPlaylist;

    public Playlist() {
    }

    public Playlist(int id, String name, int countOfSongs, User user, Set<Song> songsInPlaylist) {
        this.id = id;
        this.name = name;
        this.countOfSongs = countOfSongs;
        this.user = user;
        this.songsInPlaylist = songsInPlaylist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfSongs() {
        return countOfSongs;
    }

    public void setCountOfSongs(int countOfSongs) {
        this.countOfSongs = countOfSongs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Song> getSongsInPlaylist() {
        return songsInPlaylist;
    }

    public void setSongsInPlaylist(Set<Song> songsInPlaylist) {
        this.songsInPlaylist = songsInPlaylist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return id == playlist.id &&
                countOfSongs == playlist.countOfSongs &&
                Objects.equals(name, playlist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countOfSongs);
    }
}
