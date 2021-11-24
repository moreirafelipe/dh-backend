package compra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Item {
    private final String nome;
    private final BigDecimal valor;
}
