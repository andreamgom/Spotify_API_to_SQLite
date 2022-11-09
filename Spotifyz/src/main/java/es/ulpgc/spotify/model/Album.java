package es.ulpgc.spotify.model;

public class Album {

    public String title;
    public String author;
    public String ReleaseDate;
    public int totalTracks;


    public Album(String title, String name, String ReleaseDate, int totalTracks){
        this.title = title;
        this.author = name;
        this.ReleaseDate = ReleaseDate;
        this.totalTracks = totalTracks;
    }

}
