import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class SpotifyApp {

    public static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printSpootifyLogo(){
        System.out.println("\u001B[32m\n               ⢀⣠⣤⣤⣶⣶⣶⣶⣤⣤⣄⡀\n        ⠀   ⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀\n        ⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦\n        ⠀⢀⣾⣿⡿⠿⠛⠛⠛⠉⠉⠉⠉⠛⠛⠛⠿⠿⣿⣿⣿⣿⣿⣷⡀\n        ⠀⣾⣿⣿⣇⠀⣀⣀⣠⣤⣤⣤⣤⣤⣀⣀⠀⠀⠀⠈⠙⠻⣿⣿⣷ \n        ⢠⣿⣿⣿⣿⡿⠿⠟⠛⠛⠛⠛⠛⠛⠻⠿⢿⣿⣶⣤⣀⣠⣿⣿⣿⡄\n        ⢸⣿⣿⣿⣿⣇⣀⣀⣤⣤⣤⣤⣤⣄⣀⣀⠀⠀⠉⠛⢿⣿⣿⣿⣿⡇  sPOOtify\n        ⠘⣿⣿⣿⣿⣿⠿⠿⠛⠛⠛⠛⠛⠛⠿⠿⣿⣶⣦⣤⣾⣿⣿⣿⣿⠃  by: @duvrdx\n        ⠀⢿⣿⣿⣿⣿⣤⣤⣤⣤⣶⣶⣦⣤⣤⣄⡀⠈⠙⣿⣿⣿⣿⣿⡿\n        ⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⡿⠁\n        ⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟\n        ⠀⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠁\n        ⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠿⠿⠿⠿⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀\n\n");
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
        System.out.println("==================================================================================+++---");
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
        if(!filteredList.isEmpty()){
            for (SpootifyContent spootifyContent : filteredList){
                if(spootifyContent.getClass() == SpootifyMusic.class) actualType = "Música";
                if(spootifyContent.getClass() == SpootifyPodcast.class) actualType = "Podcast";
                if(spootifyContent.getClass() == SpootifyAudiobook.class) actualType = "Audiobook";
                System.out.printf("%d | %s - Título: %s - Duração: %d segundos\n", counter, actualType, spootifyContent.getTitle(), spootifyContent.getDuration());
                counter += 1;
            }
        }else{
            System.out.println("Não existem conteúdos que atendam esse requisito :(");
        }
        System.out.println("==================================================================================+++---");
        System.out.println("Pressione 'ENTER' para voltar ao menu");
        System.out.println("==================================================================================+++---");
        dataScanner.nextLine();

    }

    public static void createPlaylist(Scanner dataScanner, SpootifyMenu menu){
        String playlistTitle;

        printSpootifyLogo();
        System.out.println("==================================================================================+++---");
        System.out.println("Digite o nome da playlist");
        System.out.println("==================================================================================+++---");
        playlistTitle = dataScanner.nextLine();
        
        if(!menu.playlistExists(playlistTitle)){
            menu.addPlaylist(playlistTitle);
            System.out.println("A playlist " + playlistTitle + " foi criada com sucesso!\n ");
        } else{
            System.out.println("Já existe uma playlist chamada " + playlistTitle + "!");
        }
        System.out.println("==================================================================================+++---");
        System.out.println("Pressione 'ENTER' para voltar ao menu");
        System.out.println("==================================================================================+++---");
        dataScanner.nextLine();
    }
    
    public static void deletePlaylist(Scanner dataScanner, SpootifyMenu menu){
        String playlistTitle;

        printSpootifyLogo();
        System.out.println("==================================================================================+++---");
        System.out.println("Digite o nome da playlist");
        System.out.println("==================================================================================+++---");
        playlistTitle = dataScanner.nextLine();
        
        if(menu.playlistExists(playlistTitle)){
            menu.removePlaylist(playlistTitle);
            System.out.println("A playlist " + playlistTitle + " foi removida com sucesso!\n ");
        } else if(playlistTitle == "library")
            System.out.println("Não é possivel apagar a biblioteca!");
        else
            System.out.println("Não existe uma playlist chamada " + playlistTitle + "!");

        System.out.println("==================================================================================+++---");
        System.out.println("Pressione 'ENTER' para voltar ao menu");
        System.out.println("==================================================================================+++---");
        dataScanner.nextLine();
    }

    public static void showPlaylists(Scanner dataScanner, SpootifyMenu menu){
        
        if(menu.getPlaylists().size() > 1){
            for(String playlistTitle : menu.getPlaylists().keySet()){
                if(playlistTitle != "library")
                    System.out.println(menu.getPlaylist(playlistTitle).getDescription());
            }
        }else{
            System.out.println("Você não possui playlists :(");
        }
        System.out.println("==================================================================================+++---");
        System.out.println("Pressione 'ENTER' para voltar ao menu");
        System.out.println("==================================================================================+++---");
        dataScanner.nextLine();
    }

    public static void main(String[] args){
        SpootifyMenu myMenu = new SpootifyMenu();
        Scanner dataScanner = new Scanner(System.in);
        int actualCommand = 0;
        String playlistTitle;

        // Criando playlist com dados do usuário
        clearTerminal();
        printSpootifyLogo();
        System.out.println("Olá, seja bem vindo ao sPOOtify!\n");

        while(actualCommand != 4){
            clearTerminal();
            printSpootifyLogo();
            System.out.println("Selecione uma opção");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Preencher a sua Biblioteca           | 2. Listar os conteúdos da Bilioteca\n3. Exibir informações da Biblioteca     | 4. Criar uma nova Playlist");
            System.out.println("5. Excluir uma Playlist                 | 6. Adicionar conteúdo a Playlist\n7. Listar Playlists                     | 8. Sair");
            System.out.println("==================================================================================+++---");
            actualCommand = dataScanner.nextInt();
            dataScanner.nextLine();

            clearTerminal();
            printSpootifyLogo();

            switch(actualCommand){
                // Adicionar conteúdo a biblioteca
                case 1:
                    addToPlaylist(dataScanner, "library", myMenu);
                    break;

                // Listar conteúdos da biblioteca
                case 2:
                    showPlaylistContent(dataScanner, "library", myMenu);
                    break;

                // Exibir informações da biblioteca
                case 3:
                    System.out.println(myMenu.getPlaylist("library").getDescription());
                    System.out.println("==================================================================================+++---");
                    System.out.println("Pressione 'ENTER' para voltar ao menu");
                    System.out.println("==================================================================================+++---");
                    dataScanner.nextLine();
                    break;
                
                // Criar nova playlist
                case 4:
                    createPlaylist(dataScanner, myMenu);
                    break;
                
                // Criar nova playlist
                case 5:
                    deletePlaylist(dataScanner, myMenu);
                    break;
                
                // Adicionar a uma playlist
                case 6:
                    System.out.println("==================================================================================+++---");
                    System.out.println("Digite o nome da playlist");
                    System.out.println("==================================================================================+++---");
                    playlistTitle = dataScanner.nextLine();
                    if(myMenu.playlistExists(playlistTitle)) addToPlaylist(dataScanner, playlistTitle, myMenu);
                    else{
                        System.out.println("Essa playlist não existe!");
                        System.out.println("==================================================================================+++---");
                        System.out.println("Pressione 'ENTER' para voltar ao menu");
                        System.out.println("==================================================================================+++---");
                        dataScanner.nextLine();
                    }
                    break;

                // Listando playlists
                case 7:
                    showPlaylists(dataScanner, myMenu);
                    break;

                // Sair
                case 8:
                    System.out.println("Saindo...");
                    break;
            }

        }

    }
}
