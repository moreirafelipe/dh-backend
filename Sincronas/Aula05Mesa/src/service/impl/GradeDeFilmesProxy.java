package service.impl;

import model.Filme;
import model.Ip;
import service.IGradeDeFilmes;

import java.util.ArrayList;
import java.util.stream.Stream;

public class GradeDeFilmesProxy implements IGradeDeFilmes {
    private Ip ip;
    protected GradeDeFilmes gradeConsulta;
    protected String paisConsulta;

//    Construtor que inicia objeto proxy já populado
    public GradeDeFilmesProxy(Ip ip) {
        this.ip = ip;
        this.gradeConsulta =  new GradeDeFilmes();
        gradeConsulta.addFilme(new Filme("Matrix 1", "BR", "https://www.youtube.com/watch?v=2KnZac176Hs"));
        gradeConsulta.addFilme(new Filme("Matrix 2", "COL", "https://www.youtube.com/watch?v=kYzz0FSgpSU"));
        gradeConsulta.addFilme(new Filme("Matrix 3", "AR", "https://www.youtube.com/watch?v=hMbexEPAOQI"));
        gradeConsulta.addFilme(new Filme("Matrix 4", "BR", "https://www.youtube.com/watch?v=Wg7V2_OBXwQ"));
    }

    @Override
    public Filme getFilme(String nome) throws FilmeNaoHabilitadoException {

        Filme filmeResult = null;
        ArrayList<Filme> filmeQuery = gradeConsulta.getListaFilmes(nome);

        //        Define país do proxy cliente
        if(ip.getOcteto1() >= 0 && ip.getOcteto1() <= 49) {
            paisConsulta = "AR";
        } else if (ip.getOcteto1() <= 99) {
            paisConsulta = "BR";
        } else if (ip.getOcteto1() <= 147) {
            paisConsulta = "COL";
        } else {
            System.out.println("Faixa de IP não atribuida a este país!");
        }

//        Checa se limite de pedido de séries foi atingido e se está disponível no país conforme IP e pais cadastrado
        try {
            if(filmeQuery != null) {
                filmeResult = filmeQuery.stream().filter(filme -> filme.getPais().equalsIgnoreCase(paisConsulta))
                        .findFirst()
                        .orElseThrow(FilmeNaoHabilitadoException::new);

                System.out.println("Filme: " + filmeResult.getNome() + "\nPaís: " + filmeResult.getPais() + " \nLink" +
                        ": " + filmeResult.getLink());
            }
        } catch(Exception e) { // Lança exceção caso filme não esteja cadastrado para o país do IP cliente
            System.out.println(e.getMessage());
        }
        return filmeResult;
    }
}
