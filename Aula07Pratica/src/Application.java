import dto.MusicaDTO;
import factory.MusicaFactory;

public class Application {

    public static void main(String[] args) {
        final MusicaFactory playlist = new MusicaFactory("Blues");
        MusicaDTO musicaBusca = playlist.getMusica("Who did you think I was");

        final MusicaDTO requisicao1 = playlist.getMusica("Who did you think I was");
        System.out.println(requisicao1.toString());
    }
}
