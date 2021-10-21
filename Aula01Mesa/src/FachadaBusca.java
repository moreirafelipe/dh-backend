import java.time.LocalDate;
import java.util.ArrayList;

public class FachadaBusca implements IBuscar{

    private VooService vooService;
    private HotelService hotelService;

    public FachadaBusca() {
        this.vooService = new VooService();
        this.hotelService = new HotelService();
    }

    public void buscar(String origem, String destino, LocalDate dataIda, LocalDate dataVolta) {

        Hotel hotelConsulta = new Hotel(dataIda, dataVolta, destino);
        Voo vooConsulta = new Voo(dataIda, dataVolta, origem, destino);

        hotelService.buscar(hotelConsulta);
        vooService.buscar(vooConsulta);

    }
}
