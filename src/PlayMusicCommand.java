/**
 * Comando para tocar música.
 */
public class PlayMusicCommand extends Command {

    /**
     * Menu do Spotify.
     */
    private SpootifyMenu spootifyMenu;

    /**
     * Título da música.
     */
    private String songTitle;

    public PlayMusicCommand(SpootifyMenu spootifyMenu, String songTitle) {
        this.spootifyMenu = spootifyMenu;
        this.songTitle = songTitle;
    }

    @Override
    public void execute() {
        // Toca a música com o título especificado.
        spootifyMenu.playMusic(songTitle);
    }
}