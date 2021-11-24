package factory;

import dto.Arvore;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static Map<String, Arvore> FLORESTA = new HashMap<>();

    public Arvore getArvore(double altura, double largura, String cor, String tipo) {

        String chave = "key: " + altura + ":"+largura+":"+tipo;
//        System.out.println(chave);

        if(!FLORESTA.containsKey(chave)) {
            FLORESTA.put(chave, new Arvore(altura, largura, cor, tipo));
//            System.out.println("Arvore criada!");
            return FLORESTA.get(chave);
        }
//        System.out.println("Recuperando árvore do cache!");
        return FLORESTA.get(chave);
    }
}
