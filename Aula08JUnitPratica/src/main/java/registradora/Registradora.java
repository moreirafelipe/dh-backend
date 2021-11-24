package registradora;

import banco_de_dados.BancoDeDados;
import cliente.Cliente;
import compra.Compra;
import lombok.Builder;
import venda.Venda;
import vendedor.Vendedor;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public class Registradora {
    private final Compra compra;
    private final BigDecimal valorRecebido;
    private final Vendedor vendedor;
    private final Cliente cliente;

    public void efetivarVenda() {
        var totalCompra = compra.getTotal();
        var troco = valorRecebido.subtract(totalCompra);
        var venda = Venda.builder()
                .totalCompra(totalCompra)
                .troco(troco)
                .vendedor(vendedor)
                .cliente(cliente)
                .build();

        BancoDeDados.addVenda(venda);
    }
}
