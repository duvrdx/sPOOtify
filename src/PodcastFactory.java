import java.util.Scanner;

public class PodcastFactory extends   ContentFactory{
    @Override
    public SpootifyContent create() {
        Scanner dataScanner = new Scanner(System.in);
        String title;
        int duration;
        String presenter;
        String review;

        System.out.println("Titulo:");
        title = dataScanner.nextLine();

        System.out.println("Duração:");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();

        System.out.println("Apresentador:");
        presenter = dataScanner.nextLine();

        System.out.println("Descrição:");
        review = dataScanner.nextLine();

        return new SpootifyPodcast(title, duration, presenter, review);
    }
}
