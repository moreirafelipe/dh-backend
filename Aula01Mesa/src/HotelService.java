import java.time.LocalDate;

public class HotelService {
    public void buscar(Hotel hotel) {

    Hotel hotelConsulta = new Hotel(LocalDate.of(2021,10,17), LocalDate.of(2021,10,20), "Italia");

        if(hotel.getCidade() == hotelConsulta.getCidade() && hotel.getDataEntrada().equals(hotelConsulta.getDataEntrada()) && hotel.getDataSaida().equals(hotelConsulta.getDataSaida()))  {
            System.out.println("Hotel disponível!");
        } else {
            System.out.println("Hotel Não disponível!");
        }
    }
}
