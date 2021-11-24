import dto.Computador;
import factory.ComputadorFactory;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final ComputadorFactory computador1 = new ComputadorFactory();

        Computador mac = computador1.getComputador(8, 500, 1);
        Computador pc = computador1.getComputador(16, 128, 2);
        Computador pc2 = computador1.getComputador(16, 128, 2);
        Computador mac2 = computador1.getComputador(32, 128, 3);

        System.out.println(mac.toString());
        System.out.println(pc.toString());
        System.out.println(mac2.toString());

    }
}
