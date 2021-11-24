import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculadora {

    public boolean checarComprimento(List<Integer> lista) {
     return lista.size() > 5 || lista.size() > 10;
    }

    public double checarMedia(List<Integer> lista) {
     return lista.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }

    public double checarMaximo(List<Integer> lista) {
     return lista.stream().mapToDouble(Integer::doubleValue).max().orElse(0.0);
    }

    public double checarMinimo(List<Integer> lista) {
     return lista.stream().mapToDouble(Integer::doubleValue).min().orElse(0.0);
    }
}
