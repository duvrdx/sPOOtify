import java.util.List;

public class SpootifyMusic extends SpootifyContent {
    private List<String> songwriters;
    private List<String> interpreters;
    private String genre;

    public SpootifyMusic(String title, int duration, List<String> songwriters, List<String> interpreters, String genre){
        super(title, duration);
        this.songwriters = songwriters;
        this.interpreters = interpreters;
        this.genre = genre;
    }

    public List<String> getSongwriters() {
        return this.songwriters;
    }
    
    public void setSongwriters(List<String> songwriters) {
        this.songwriters = songwriters;
    }
    
    public List<String> getInterpreters() {
        return this.interpreters;
    }
    
    public void setInterpreters(List<String> interpreters) {
        this.interpreters = interpreters;
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

}
