package es.ulpgc.spotify;


import es.ulpgc.spotify.database.MusicDatabase;
import es.ulpgc.spotify.database.SqliteMusicDatabase;
import es.ulpgc.spotify.model.Album;
import es.ulpgc.spotify.model.Artist;
import es.ulpgc.spotify.model.Track;
import es.ulpgc.spotify.webservice.Json;
import es.ulpgc.spotify.webservice.MusicSource;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {


        MusicSource source = new Json();
        Map<String, String> Ids = Map.of(
                "Bad Bunny", "4q3ewBCX7sLwd24euuV69X",
                "Rauw Alejandro", "4q3ewBCX7sLwd24euuV69X",
                "Ozuna", "1i8SpTcr7yvPOmcqrbnVXY",
                "Feid", "2LRoIwlKmHjgvigdNGBHNo",
                "Rosalía", "7ltDVBr6mKbRvohxheJ9h1");

        for (String id: Ids.values()) {
            List<Artist> artistList = source.artistsOf(id);
            List<Album> albumsList = source.albumsOf(id);
            List<Track> trackList = source.tracksOf(id);
            MusicDatabase musicDatabase = new SqliteMusicDatabase();


            for (Artist artist : artistList) {
                musicDatabase.add(artist);
            }

            for (Album album : albumsList) {
                musicDatabase.add(album);
            }

            for (Track track : trackList) {
                musicDatabase.add(track);
            }

        }
    }
}