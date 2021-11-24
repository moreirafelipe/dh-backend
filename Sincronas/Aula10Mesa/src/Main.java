import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> listaInteiros = Arrays.asList(10,20,30,40);
        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.checarComprimento(listaInteiros));
        System.out.println(calculadora.checarMedia(listaInteiros));
        System.out.println(calculadora.checarMinimo(listaInteiros));
        System.out.println(calculadora.checarMaximo(listaInteiros));
    }
}
