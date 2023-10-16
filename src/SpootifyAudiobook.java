import java.util.InputMismatchException;
import java.util.List;

public class SpootifyAudiobook extends SpootifyContent{
    private List<String> authors;
    private String publisher;
    private String storyteller;
    private String synopsis;

    
    
    public SpootifyAudiobook(String title, int duration, String storyteller, String synopsis, List<String> authors, String publisher){
        super(title, duration);

        if(storyteller.isBlank() || synopsis.isBlank() || authors.isEmpty() || publisher.isBlank())
            throw new InputMismatchException("Entrada invalida");
        this.storyteller = storyteller;
        this.synopsis = synopsis;
        this.authors = authors;
        this.publisher = publisher;
    }
    
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public List<String> getAuthors() {
        return this.authors;
    }
    
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    public String getStoryteller() {
        return this.storyteller;
    }

    public void setStoryteller(String storyteller) {
        this.storyteller = storyteller;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    public String toString(){
        String authorsString = "";

        for(String author : authors){
            authorsString += author + ";";
        }

        authorsString = authorsString.replaceFirst(".$","");

        return String.format("Audiobook | Título: %s | Duração: %d segundos | Narrador: %s | Autores: %s | Editora: %s |", title, duration, storyteller, authorsString, publisher);
    }
}
