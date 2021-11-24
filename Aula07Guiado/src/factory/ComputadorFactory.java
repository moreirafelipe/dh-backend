package factory;

import dto.Computador;

import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {
    private static Map<String, Computador> COMPUTADORES = new HashMap<>();

    public Computador getComputador(int ram, int hd, int id) {
        String chave = "key: " + ram + ":"+hd+":"+id;
        System.out.println(chave);

        if(!COMPUTADORES.containsKey(chave)) {
            COMPUTADORES.put(chave, new Computador(ram, hd, id));
            System.out.println("PC criado!");

            return COMPUTADORES.get(chave);
        }
        System.out.println("PC Recuperado do cache!");
        return COMPUTADORES.get(chave);
    }
}
