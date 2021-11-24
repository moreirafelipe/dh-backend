import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate dataIda = LocalDate.of(2021,10,17);
        LocalDate dataVolta = LocalDate.of(2021,10,20);

        FachadaBusca busca = new FachadaBusca();
        busca.buscar("São Paulo", "Italia", dataIda, dataVolta);

    }
}