package service.impl;

import model.Filme;
import model.Serie;
import service.ISerie;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GradeDeSeries implements ISerie {

    private ArrayList<Serie> listaSeries;
    public GradeDeSeries() {
        this.listaSeries =  new ArrayList<>();
    }

    public ArrayList<Serie> getListaSeries(String nome) {
        ArrayList<Serie> seriesResult = new ArrayList<>();

        try {
            if(!Objects.isNull(getSerie(nome))) {
                for(Serie serie : listaSeries) {
                    if(serie.getNome().equalsIgnoreCase(nome)) seriesResult.add(serie);
                }
            };
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return seriesResult;
    }

    public void addSerie(Serie serie) {
        listaSeries.add(serie);
    }

    @Override
    public Serie getSerie(String nome) {
        return listaSeries.stream()
                .filter(serie -> serie.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
    }
}
