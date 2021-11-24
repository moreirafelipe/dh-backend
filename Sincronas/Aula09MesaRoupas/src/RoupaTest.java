import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoupaTest {

    //Teste para verificar se a fábrica retorna o item que precisamos
    @Test
    void retornaRoupa() {

        System.out.println("1. Teste para verificar se a fábrica retorna o item que precisamos");

        //Cadastra novos tipos e novos modelos de roupa
       Roupa calca = RoupaFactory.obterRoupa("calca", "M", true, true);
       Roupa camisa = RoupaFactory.obterRoupa( "camisa", "XS", false, false);
       Roupa blusa = RoupaFactory.obterRoupa("blusa", "S", true, false);

        //Retorna novo modelo criado a partir de um tipo do cache
        Roupa blusa2 = RoupaFactory.obterRoupa("blusa", "S", true, true);

        //Retorna blusa já no cache de tipo e de modelos
       Roupa blusa3 = RoupaFactory.obterRoupa("blusa", "S", true, false);


        System.out.println("\n" +
                "------------------------------------------------------------------------------------------------");
       System.out.println("\nRetornando itens por código(chave)");
       assertEquals("calca", RoupaFactory.retornaItem("calca:M:true:true"));
       assertEquals("blusa", RoupaFactory.retornaItem("blusa:S:true:false"));

    }

//    Teste que mede o tamanho da fábrica e mostra que é menor que o número de pedidos
    @Test
    void medeTamanhoFabrica() {

        System.out.println("2. Teste que mede o tamanho da fábrica e mostra que é menor que o número de pedidos");

//        Fazendo pedidos
        //Cadastra novos tipos e novos modelos de roupa
        Roupa calca = RoupaFactory.obterRoupa("calca", "M", true, true);
        Roupa camisa = RoupaFactory.obterRoupa( "camisa", "XS", false, false);
        Roupa blusa = RoupaFactory.obterRoupa("blusa", "S", true, false);

        //Retorna novo modelo criado a partir de um tipo do cache
        Roupa blusa2 = RoupaFactory.obterRoupa("blusa", "S", true, true);

        //Retorna blusa já no cache de tipo e de modelos
        Roupa blusa3 = RoupaFactory.obterRoupa("blusa", "S", true, false);

        System.out.println("\n" +
                "------------------------------------------------------------------------------------------------");
        System.out.println("Pedidos realizados: " + RoupaFactory.pedidos);
        System.out.println("Tamanho da fábrica: " + RoupaFactory.getTamanhoFabrica() + "\n");

        assert (RoupaFactory.pedidos > RoupaFactory.getTamanhoFabrica());
    }
}
