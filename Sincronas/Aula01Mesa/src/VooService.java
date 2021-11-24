import java.time.LocalDate;

public class VooService {
    public void buscar(Voo voo) {

        Voo vooConsulta = new Voo(LocalDate.of(2021,10,17), LocalDate.of(2021,10,20), "São Paulo", "Italia");

        if(voo.getOrigem() == vooConsulta.getOrigem() && voo.getDestino() == vooConsulta.getDestino() && vooConsulta.getDataPartida().equals(voo.getDataPartida()) && vooConsulta.getDataRetorno().equals(voo.getDataRetorno()))  {
            System.out.println("Voo disponível!");
        } else {
            System.out.println("Voo Não disponível!");
        }
    };
}
