import java.time.LocalDate;

public interface IBuscar {
    public void buscar(String origem, String destino, LocalDate dataIda, LocalDate  dataVolta);
}