package es.ulpgc.spotify.database;

import es.ulpgc.spotify.model.Artist;
import es.ulpgc.spotify.model.Album;
import es.ulpgc.spotify.model.Track;

import java.sql.SQLException;

public interface MusicDatabase {
    void add(Artist artist) throws SQLException;
    void add(Album albums) throws SQLException;
    void add(Track track) throws SQLException;
}
