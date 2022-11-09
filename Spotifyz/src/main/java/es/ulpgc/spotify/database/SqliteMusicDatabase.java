package es.ulpgc.spotify.database;

import es.ulpgc.spotify.model.Album;
import es.ulpgc.spotify.model.Artist;
import es.ulpgc.spotify.model.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteMusicDatabase implements MusicDatabase {

    private final Connection connection;

    public SqliteMusicDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        initDatabase();
    }
    private static final String ARTISTS =
            "CREATE TABLE IF NOT EXISTS artists (" +
                    "id TEXT PRIMARY KEY, " +
                    "name TEXT, " +
                    "popularity NUMBER, " +
                    "genres TEXT, " +
                    "followers NUMBER);";

    private static final String ALBUMS =
            "CREATE TABLE IF NOT EXISTS albums (" +
                    "title TEXT, " +
                    "author TEXT, " +
                    "ReleaseDate TEXT, " +
                    "totalTracks NUMBER);";

    private static final String TRACKS =
            "CREATE TABLE IF NOT EXISTS tracks (" +
                    "title TEXT, " +
                    "author TEXT, " +
                    "duration NUMBER, " +
                    "explicit BOOLEAN);";

    private void initDatabase() throws SQLException{
        connection.createStatement().execute(ARTISTS);
        connection.createStatement().execute(ALBUMS);
        connection.createStatement().execute(TRACKS);
    }



    @Override
    public void add(Artist artist) throws SQLException {
        try{
            connection.createStatement().execute(DMLTranslator.insertStatementOf(artist));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Album albums) throws SQLException {
        try{
            connection.createStatement().execute(DMLTranslator.insertStatementOf(albums));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Track track) throws SQLException {
        try{
            connection.createStatement().execute(DMLTranslator.insertStatementOf(track));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
