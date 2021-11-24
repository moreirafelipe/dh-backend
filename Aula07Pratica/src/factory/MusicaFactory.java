package factory;

import dto.MusicaDTO;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class MusicaFactory {

    private String nomePLaylist = null;
    private static final HashMap<String, MusicaDTO> PLAYLIST = new HashMap<>();

    public MusicaFactory(String nomePlaylist) {
        this.nomePLaylist = nomePlaylist;
    }

    public MusicaDTO getMusica(final String nomeMusica) {
        MusicaDTO musica = PLAYLIST.get(nomeMusica);

        if(Objects.isNull(musica)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Adicionando musica " + nomeMusica + " na playlist " + nomePLaylist);

            System.out.println("Digite o artista que interpreta esta musica");
            String artista = scan.nextLine();

            System.out.println("Agora digite o gênero desta musica");
            String genero = scan.nextLine();

            PLAYLIST.put(nomeMusica, new MusicaDTO(nomeMusica, artista, genero));
            System.out.println("Musica " + nomeMusica + " adicionada com sucesso!");
        }
        System.out.println("Musica " + nomeMusica + " selecionada da playlist " + nomePLaylist);
        return musica;
    }
}
