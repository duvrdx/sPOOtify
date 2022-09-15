import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SpootifyPlaylist extends SpootifyContent {
    private List<SpootifyContent> contentList;
    
    public SpootifyPlaylist(String title){
        super(title, 0);
        contentList = new LinkedList<SpootifyContent>();
    }

    public List<SpootifyContent> getContentList() {
        return this.contentList;
    }

    public void setContentList(List<SpootifyContent> contentList) {
        this.contentList = contentList;
    }

    public String getDurationFormated(){
        int hours;
        int minutes;
        int seconds = this.getDuration();

        hours = seconds / 3600;
        seconds %= 3600;
        minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void addContent(SpootifyContent content){
        contentList.add(content);
        this.setDuration(this.getDuration() + content.getDuration());
    }

    public void removeContent(SpootifyContent content){
        if(contentList.contains(content))
            contentList.remove(content);
            this.setDuration(this.getDuration() - content.getDuration());
    }

    public List<SpootifyContent> filterBy(boolean music, boolean podcast, boolean audiobook){

        List<SpootifyContent> filteredList = new ArrayList<SpootifyContent>();
        
        for (SpootifyContent content : this.contentList){

            if(content.getClass() == SpootifyMusic.class && music)
                filteredList.add(content);

            if(content.getClass() == SpootifyPodcast.class && podcast)
                filteredList.add(content);

            if(content.getClass() == SpootifyAudiobook.class && audiobook)
                filteredList.add(content);
        }

        return filteredList;
    }

    public String getDescription(){
        String titulo = this.getTitle();
        if(titulo == "library") titulo = "Biblioteca";
        return String.format("Título da Playlist: %s\nDuração: %s\nConteúdos: %d ", titulo, getDurationFormated(), contentList.size());
    }
}
