import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicFactory extends ContentFactory {
    @Override
    public SpootifyContent create() {
        Scanner dataScanner = new Scanner(System.in);
        Scanner stringCutter;
        String title;
        int duration;
        List<String> songwriters = new ArrayList<String>();
        String bigSW;
        List<String> interpreters = new ArrayList<String>();
        String bigIT;
        String genre;

        System.out.println("Titulo:");
        title = dataScanner.nextLine();

        System.out.println("Duração:");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();

        System.out.println("Genero:");
        genre = dataScanner.nextLine();

        System.out.println("Compositores: Separe com ;");
        bigSW = dataScanner.nextLine();

        System.out.println("Interpretes: Separe com ;");
        bigIT = dataScanner.nextLine();

        stringCutter = new Scanner(bigSW);
        stringCutter.useDelimiter(";");

        while(stringCutter.hasNext()){
            songwriters.add(stringCutter.next());
        }
        stringCutter.close();

        stringCutter = new Scanner(bigIT);
        stringCutter.useDelimiter(";");

        while(stringCutter.hasNext()){
            interpreters.add(stringCutter.next());
        }
        stringCutter.close();

        return new SpootifyMusic(title, duration, songwriters, interpreters, genre);
    }
}
