import java.util.HashMap;
import java.util.Map;

public class SpootifyMenu {
    private Map<String, SpootifyPlaylist> playlists;
    
    public SpootifyMenu(){
        
        playlists = new HashMap<String, SpootifyPlaylist>();
    }

    public void addPlaylist(String playlistTitle){
        if(!playlistExists(playlistTitle))
            playlists.put(playlistTitle, new SpootifyPlaylist(playlistTitle));
    }

    public SpootifyPlaylist getPlaylist(String playlistTitle){
        return playlists.get(playlistTitle);
    }

    public void removePlaylist(String playlistTitle){
        playlists.remove(playlistTitle);
    }

    public boolean playlistExists(String playlistTitle){
        return playlists.containsKey(playlistTitle);
    }

    public void addContent(String playlistTitle, SpootifyContent content){
        getPlaylist(playlistTitle).addContent(content);
    }

    public void removeContent(String playlistTitle, SpootifyContent content){
        getPlaylist(playlistTitle).removeContent(content);
    }

    public String getContentDescription(SpootifyContent content){
        String contentClass = "";
        
        if(content.getClass() == SpootifyMusic.class) contentClass = "Música";
        if(content.getClass() == SpootifyPodcast.class) contentClass = "Podcast";
        if(content.getClass() == SpootifyAudiobook.class) contentClass = "Audiobook";

        return String.format("%s - %s", contentClass, content.toString());
        
    }
}
