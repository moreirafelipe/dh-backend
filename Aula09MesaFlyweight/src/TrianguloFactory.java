import java.util.HashMap;
import java.util.Map;

public class TrianguloFactory {

    public static final Map<String, Triangulo> trianguloMap = new HashMap<>();

    public static Triangulo obterTriangulo(String cor, int tamanho) {
        Triangulo triangulo = trianguloMap.get(cor);

        if(triangulo == null){
            triangulo = new Triangulo(cor, tamanho);
            trianguloMap.put(cor, triangulo);
        }
        return triangulo;
    }
}
