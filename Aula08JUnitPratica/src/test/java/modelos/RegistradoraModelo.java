package modelos;

import cliente.Cliente;
import registradora.Registradora;
import vendedor.Vendedor;

public class RegistradoraModelo {

    public static Registradora.RegistradoraBuilder construirCenario() {
        return Registradora.builder()
                .vendedor(new Vendedor(1, "Jet Li"))
                .cliente(new Cliente("Bruce Lee"));
    }
}
