package com.epam.andriushchenko.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalTime duration;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "songs_playlists",
            joinColumns = {@JoinColumn(name = "song_id")}, inverseJoinColumns = {@JoinColumn(name = "playlist_id")})
    private Set<Playlist> playlistsWithThisSong;

    public Song() {
    }

    public Song(int id, String name, LocalTime duration, Set<Playlist> playlistsWithThisSong) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.playlistsWithThisSong = playlistsWithThisSong;
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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public Set<Playlist> getPlaylistsWithThisSong() {
        return playlistsWithThisSong;
    }

    public void setPlaylistsWithThisSong(Set<Playlist> playlistsWithThisSong) {
        this.playlistsWithThisSong = playlistsWithThisSong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id &&
                Objects.equals(name, song.name) &&
                Objects.equals(duration, song.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
