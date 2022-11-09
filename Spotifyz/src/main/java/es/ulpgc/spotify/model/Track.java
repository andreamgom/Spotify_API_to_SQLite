package es.ulpgc.spotify.model;

public class Track {

    public String author;
    public String title;
    public boolean explicit;
    public int duration;

    public Track(String title, String name, int duration, boolean explicit) {
        this.title = title;
        this.author = name;
        this.duration = duration;
        this.explicit = explicit;
    }

}
