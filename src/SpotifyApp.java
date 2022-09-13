import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpotifyApp {

    public static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printSpootifyLogo(){
        System.out.println("               ⢀⣠⣤⣤⣶⣶⣶⣶⣤⣤⣄⡀\n        ⠀   ⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀\n        ⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦\n        ⠀⢀⣾⣿⡿⠿⠛⠛⠛⠉⠉⠉⠉⠛⠛⠛⠿⠿⣿⣿⣿⣿⣿⣷⡀\n        ⠀⣾⣿⣿⣇⠀⣀⣀⣠⣤⣤⣤⣤⣤⣀⣀⠀⠀⠀⠈⠙⠻⣿⣿⣷ \n        ⢠⣿⣿⣿⣿⡿⠿⠟⠛⠛⠛⠛⠛⠛⠻⠿⢿⣿⣶⣤⣀⣠⣿⣿⣿⡄\n        ⢸⣿⣿⣿⣿⣇⣀⣀⣤⣤⣤⣤⣤⣄⣀⣀⠀⠀⠉⠛⢿⣿⣿⣿⣿⡇  sPOOtify\n        ⠘⣿⣿⣿⣿⣿⠿⠿⠛⠛⠛⠛⠛⠛⠿⠿⣿⣶⣦⣤⣾⣿⣿⣿⣿⠃  by: @duvrdx\n        ⠀⢿⣿⣿⣿⣿⣤⣤⣤⣤⣶⣶⣦⣤⣤⣄⡀⠈⠙⣿⣿⣿⣿⣿⡿\n        ⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⡿⠁\n        ⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟\n        ⠀⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠁\n        ⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠿⠿⠿⠿⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀\n\n");
    }
    
    public static SpootifyMusic createMusic(Scanner dataScanner){
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

    public static SpootifyPodcast createPodcast(Scanner dataScanner){
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

    public static SpootifyAudiobook createAudioook(Scanner dataScanner){
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

        return new SpootifyAudiobook(title, duration, storyteller, synopsis, authors, publisher);
    }

    public static void addToPlaylist(Scanner dataScanner, String playlistTitle, SpootifyMenu menu){
        boolean wannaAdd = true;
        int actualCommand;
        while(wannaAdd){
            clearTerminal();
            printSpootifyLogo();
            System.out.println("Que tipo de conteúdo deseja adicionar?");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Música | 2. Podcast | 3. Audiobook");
            actualCommand = dataScanner.nextInt();
            dataScanner.nextLine();
            
            switch (actualCommand) {
                case 1:
                    menu.getPlaylist(playlistTitle).addContent(createMusic(dataScanner));
                    System.out.println("Música adicionada com sucesso!");
                    break;
                
                case 2:
                    menu.getPlaylist(playlistTitle).addContent(createPodcast(dataScanner));
                    System.out.println("Podcast adicionado com sucesso!");
                    break;
                
                case 3:
                    menu.getPlaylist(playlistTitle).addContent(createAudioook(dataScanner));
                    System.out.println("Audiobook adicionado com sucesso!");
                    break;
                }
                
            System.out.println("==================================================================================+++---");
            System.out.println("Deseja adicionar mais um conteúdo?");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Sim | 2. Voltar ao menu");
            actualCommand = dataScanner.nextInt();
            dataScanner.nextLine();
            if(actualCommand != 1) wannaAdd = false;
        }
    }

    public static void showPlaylistContent(Scanner dataScanner, String playlistTitle, SpootifyMenu menu){
        List<SpootifyContent> filteredList = new ArrayList<SpootifyContent>();
        int actualCommand;
        int counter = 1;
        String actualType = "";

        clearTerminal();
        System.out.println("O que deseja listar?");
        System.out.println("==================================================================================+++---");
        System.out.println("1. Músicas | 2. Podcasts | 3. Audiobooks | 4. Todos");
        actualCommand = dataScanner.nextInt();
        dataScanner.nextLine();

        switch(actualCommand){
            case 1:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(true, false, false);
                break;
            case 2:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(false, true, true);
                break;
            case 3:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(false, false, true);
                break;
            case 4:
                filteredList = menu.getPlaylist(playlistTitle).getContentList();
                break;
        }

        clearTerminal();
        for (SpootifyContent spootifyContent : filteredList){
            if(spootifyContent.getClass() == SpootifyMusic.class) actualType = "Música";
            if(spootifyContent.getClass() == SpootifyPodcast.class) actualType = "Podcast";
            if(spootifyContent.getClass() == SpootifyAudiobook.class) actualType = "Audiobook";
            System.out.printf("%d | %s - Título: %s - Duração: %d segundos\n", counter, actualType, spootifyContent.getTitle(), spootifyContent.getDuration());
            counter += 1;
        }
        System.out.println("==================================================================================+++---");
        System.out.println("Pressione 'ENTER' para voltar ao menu");
        dataScanner.nextLine();

    }
    public static void main(String[] args){
        SpootifyMenu myMenu = new SpootifyMenu();
        Scanner dataScanner = new Scanner(System.in);
        int actualCommand = 0;
        String playlistName;

        // Criando playlist com dados do usuário
        clearTerminal();
        printSpootifyLogo();
        System.out.println("Olá, seja bem vindo ao sPOOtify!\nQual é o nome da sua playlist?");
        playlistName = dataScanner.nextLine();
        myMenu.addPlaylist(playlistName);

        System.out.println("==================================================================================+++---");
        System.out.printf("A playlist '%s' foi criada com sucesso! Pressione 'ENTER' para continuar\n", playlistName);
        dataScanner.nextLine();

        while(actualCommand != 4){
            clearTerminal();
            printSpootifyLogo();
            System.out.println("O que deseja fazer agora?");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Preencher a Playlist           | 2. Listar os conteúdos da Playlist\n3. Exibir informações da Playlist | 4. Sair");
            actualCommand = dataScanner.nextInt();
            dataScanner.nextLine();

            clearTerminal();
            printSpootifyLogo();

            switch(actualCommand){
                // Adicionar conteúdo a playlist
                case 1:
                    addToPlaylist(dataScanner, playlistName, myMenu);
                    break;

                // Listar conteúdos da playlist
                case 2:
                    showPlaylistContent(dataScanner, playlistName, myMenu);
                    break;

                // Exibir informações da playlist
                case 3:
                    System.out.println(myMenu.getPlaylist(playlistName).getDescription());
                    System.out.println("==================================================================================+++---");
                    System.out.println("Pressione 'ENTER' para voltar ao menu");
                    dataScanner.nextLine();
                    break;
                
                // Sair
                case 4:
                    System.out.println("Saindo...");
                    break;
            }

        }

    }
}
