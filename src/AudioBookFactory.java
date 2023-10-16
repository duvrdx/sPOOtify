import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AudioBookFactory extends ContentFactory {
    @Override
    public SpootifyContent create() {
        Scanner dataScanner = new Scanner(System.in);
        Scanner stringCutter;
        String title;
        int duration;
        List<String> authors = new ArrayList<String>();
        String bigAT;
        String storyteller;
        String publisher;
        String synopsis;

        System.out.println("Titulo:");
        title = dataScanner.nextLine();;

        System.out.println("Duração:");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();

        System.out.println("Editora:");
        publisher = dataScanner.nextLine();

        System.out.println("Autores: Separe com ;");
        bigAT = dataScanner.nextLine();

        System.out.println("Narrador:");
        storyteller = dataScanner.nextLine();

        System.out.println("Sinopse:");
        synopsis = dataScanner.nextLine();

        stringCutter = new Scanner(bigAT);
        stringCutter.useDelimiter(";");

        while(stringCutter.hasNext()){
            authors.add(stringCutter.next());
        }
        stringCutter.close();


        System.out.println( title + duration + storyteller +synopsis + authors + publisher);

        return new SpootifyAudiobook(title, duration, storyteller, synopsis, authors, publisher);
    }
}
