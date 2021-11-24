import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoupaTest {

    @Test
    void getRoupa() {
           Roupa calca = RoupaFactory.obterRoupa("M", "calca");
           Roupa camisa = RoupaFactory.obterRoupa("G", "camisa");
           Roupa blusa = RoupaFactory.obterRoupa("GG", "blusa");

           assertEquals("M", calca.getTamanho());
           assertEquals("GG", blusa.getTamanho());
           assertEquals("calca", calca.getTipo());
           assertEquals("blusa", blusa.getTipo());
    }

    @Test
    void getTamanhoFabrica() {

        RoupaFactory fabrica = new RoupaFactory();

        fabrica.obterRoupa("M", "calca");
        fabrica.obterRoupa("G", "calca");
        fabrica.obterRoupa("GG", "calca");
        fabrica.obterRoupa("G", "camisa");
        fabrica.obterRoupa("GG", "blusa");

        System.out.println("Pedidos realizados: " + fabrica.pedidos);
        System.out.println("Tamanho da fábrica: " + fabrica.getTamanhoFabrica());

        assert (fabrica.pedidos > fabrica.getTamanhoFabrica());
    }
}
