import java.util.HashMap;
import java.util.Map;

public class RoupaFactory {

    public static int pedidos;
    public static final Map<String, Roupa> listaFactory = new HashMap<>();
    public static final Map<String, Roupa> listaModelos = new HashMap<>();


    //Método que implementa o Flyweight Pattern
    public static Roupa obterRoupa(String tipo, String tamanho, boolean eNovo, boolean importada) {

//        Chave para identificação de cada pedido por tamanho e tipo na lista de modelos de roupas da loja
        String chave = tipo+":"+tamanho+":"+eNovo+":"+importada;

//        Cria novo tipo se este ainda não estiver no cache correspondente
        if(!listaFactory.containsKey(tipo)){

            //Inserindo roupa padrão para comparação com o "Tipo" de forma que um novo modelo do mesmo tipo seja
            // recuperável
            System.out.println("\n" +
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Cadastrando novo tipo de roupa: " + tipo);

            listaFactory.put(tipo, new Roupa(tipo, null, true, false));

            //Inserindo Objeto com modelo especificado para recuperacao em consulta com comparação de tipo e tamanho
            // na lista de modelos
            listaModelos.put(chave, new Roupa(tipo, tamanho, eNovo, importada));
            System.out.println("Inserindo novo modelo personalizado: " + listaModelos.get(chave));
            pedidos++;
            return listaFactory.get(tipo);

        } else if (!listaModelos.containsKey(chave)) {
            //Recupera objeto roupa caso tipo de roupa informado já esteja no cache de tipos, mas a roupa do tamanho
            // informado não
            // esteja no cache de modelos, e atribui uma chave para comparação posterior

            System.out.println("\n" +
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Recuperando objeto do cache de tipos: Tipo: " + tipo);
            Roupa roupaCache = listaFactory.get(tipo);
            roupaCache.setTamanho(tamanho);
            roupaCache.seteNovo(eNovo);
            roupaCache.setImportada(importada);

            listaModelos.put(chave, roupaCache);
            System.out.println("Inserindo novo modelo a partir de um tipo de roupa do cache : " + listaModelos.get(chave));

            pedidos++;
            return roupaCache;
        } else {
            pedidos++;
//        Retorna roupa que já está nos caches de tipos e de modelos conforme tipo, tamanho, se é nova e/ou importada
            System.out.println("\n" +
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Retornando modelo personalizado do cache: " + listaModelos.get(chave));
            return listaModelos.get(chave);
        }
    }

    //Método opcional para retornar itens conforme chave atribuida
    public static String retornaItem(String chaveRoupa) {
        Roupa roupaQuery = listaModelos.get(chaveRoupa);
        System.out.println("\n" +
                "------------------------------------------------------------------------------------------------");
        System.out.println("Retornando modelo: " + roupaQuery.toString());
        return roupaQuery.getTipo();
    }

//    Contabiliza o tamanho da fabrica pela quantidade de tipos de roupas
    public static int getTamanhoFabrica() {
        return listaFactory.size();
    }
}
