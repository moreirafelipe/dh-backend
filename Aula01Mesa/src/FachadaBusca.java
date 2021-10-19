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

        Hotel hotel1 = new Hotel(dataIda, dataVolta, destino);
        Voo voo1 = new Voo(dataIda, dataVolta, origem, destino);

        hotelService.buscar(hotel1);
        vooService.buscar(voo1);

    }
}
