import banco_de_dados.BancoDeDados;
import compra.Compra;
import compra.Item;
import modelos.RegistradoraModelo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class RegistradoraTeste {

    @Test
    public void deveRegistrarAVendaNoBancoDeDados() {
        //Arrange -> tradução livre = Entrada

        var pastelDeCarne = Item.builder().nome("Pastel de carne").valor(new BigDecimal("7.00")).build();
        var pastelDeFlango = Item.builder().nome("Pastel de carne").valor(new BigDecimal("6.50")).build();

        List<Item> listaItens = Arrays.asList(pastelDeCarne, pastelDeFlango);

        var compra = Compra.builder().itens(listaItens).build();

        var registradora = RegistradoraModelo.construirCenario()
                .compra(compra)
                .valorRecebido(new BigDecimal("13.50"))
                .build();

        //Act -> Ãção
        registradora.efetivarVenda();

        //Assert -> Resultado
        Assertions.assertEquals(1, BancoDeDados.vendas.size());
        Assertions.assertEquals(new BigDecimal("13.50"), BancoDeDados.vendas.get(0).getTotalCompra());
    }
}
