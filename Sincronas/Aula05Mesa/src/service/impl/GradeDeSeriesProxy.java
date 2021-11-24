package service.impl;

import model.Filme;
import model.Ip;
import model.Serie;
import service.ISerie;

import java.util.ArrayList;

public class GradeDeSeriesProxy implements ISerie {

    private Ip ip;
    private int qtdViews;
    protected GradeDeSeries gradeConsultaSeries;
    protected String paisConsulta;


//    Construtor que inicia objeto proxy já populado
    public GradeDeSeriesProxy(Ip ip) {
        this.ip = ip;
        this.qtdViews = 0;
        this.gradeConsultaSeries =  new GradeDeSeries();
        this.gradeConsultaSeries.addSerie(new Serie("The Office", "AR", "https://www.youtube.com/watch?v=2iKZmRR9AR4"));
        this.gradeConsultaSeries.addSerie(new Serie("Mr Robot", "AR", "https://www.youtube.com/watch?v=N6HGuJC--rk"));
        this.gradeConsultaSeries.addSerie(new Serie("The Boys", "COL", "https://www.youtube.com/watch?v=M1bhOaLV4FU"));
        this.gradeConsultaSeries.addSerie(new Serie("Mr Robot 2", "BR", "https://www.youtube.com/watch?v=7g8JJp0cJ50"));
    }

    @Override
    public Serie getSerie(String nome) throws SerieNaoHabilitadaException {
        Serie serieResult = null;
        ArrayList<Serie> serieQuery = gradeConsultaSeries.getListaSeries(nome);

//        Define país do proxy cliente
        if(this.ip.getOcteto1() >= 0 && this.ip.getOcteto1() <= 49) {
            this.paisConsulta = "AR";
        } else if (this.ip.getOcteto1() <= 99) {
            this.paisConsulta = "BR";
        } else if (this.ip.getOcteto1() <= 147) {
            this.paisConsulta = "COL";
        }   else {
            System.out.println("Faixa de IP não atribuida a este país!");
        }

//        Checa se limite de pedido de séries foi atingido e se está disponível no país conforme IP e pais cadastrado
        try {
            if(qtdViews < 5) { //Contabiliza apenas pedidos de séries cadastradas no país do IP informado
                serieResult =
                        this.gradeConsultaSeries.getListaSeries(nome).stream().filter(serie -> serie.getPais().equalsIgnoreCase(this.paisConsulta))
                                .findFirst()
                                .orElseThrow(SerieNaoHabilitadaException::new);

                array.stream().filter(serie -> serie.getID().equalsIgnoreCase(id))
                        .findFirst()
                        .orElse(null);

                System.out.println("Série: " + serieResult.getNome() + "\n" + "País: " + serieResult.getPais() + "\n" + "Link: " + serieResult.getLink());
                qtdViews++;
            } else {//Lança exceção caso limite de pedido de séries seja atingido
                throw new SerieNaoHabilitadaException();
            }
        } catch (Exception e) { //Lança exceção caso limite de série não seja atingido, e série não esteja cadastrada para o país do IP cliente
            System.out.println(e.getMessage());
        }
        return serieResult;
    }
}
