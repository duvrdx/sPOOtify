import java.util.InputMismatchException;

public abstract class SpootifyContent{
    protected String title;
    protected int duration;

    public SpootifyContent(String title, int duration){
        if(title.isBlank()) throw new InputMismatchException("Entrada inválida");
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString(){
        return String.format("%s - %d", title, duration);
    }
}