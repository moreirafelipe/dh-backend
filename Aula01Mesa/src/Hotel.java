import java.time.LocalDate;

public class Hotel {

    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String Cidade;

    public Hotel(LocalDate dataEntrada, LocalDate dataSaida, String cidade) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        Cidade = cidade;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }
}
