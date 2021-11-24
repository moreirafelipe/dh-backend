package service.impl;
import model.Filme;
import service.IGradeDeFilmes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GradeDeFilmes implements IGradeDeFilmes {

    private List<Filme> listaFilmes  = new ArrayList<>();
    public void addFilme(Filme filme) {
        listaFilmes.add(filme);
    }

//    Verifica previamente se filme está cadastrado
    public ArrayList<Filme> getListaFilmes(String nome) {
        ArrayList<Filme> filmesResult = new ArrayList<>();

        try {
            if (!Objects.isNull(getFilme(nome)))
                for(Filme filme : listaFilmes) {
                    if(filme.getNome().equalsIgnoreCase(nome)) filmesResult.add(filme);
                }

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return filmesResult;
    }

//    Método que retorna nome de um filme para verificação
    @Override
    public Filme getFilme(String nome) {
        return listaFilmes.stream()
                .filter(filme -> filme.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
    }
}
