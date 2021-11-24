import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrianguloTest {

    @Test
    void getTriangulo() {
        Triangulo triangulo = TrianguloFactory.obterTriangulo("verde", 4);
        Triangulo triangulo1 = TrianguloFactory.obterTriangulo("verde", 2);

        assertEquals("verde", triangulo1.getCor());
        assertEquals(4, triangulo1.getTamanho());
    }
}
