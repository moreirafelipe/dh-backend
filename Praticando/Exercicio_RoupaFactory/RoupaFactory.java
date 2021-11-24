import java.util.HashMap;
import java.util.Map;

public class RoupaFactory {

    public static int pedidos;
    public static final Map<String, Roupa> roupaMap = new HashMap<>();

    public static Roupa obterRoupa(String tamanho, String tipo) {

//        Chave para identificação de cada pedido por tamanho e tipo
        String chave = tipo+":"+tamanho;

//        Cria novo pedido se este ainda não estiver no cache
        if(!roupaMap.containsKey(chave)){
            roupaMap.put(chave ,new Roupa(tamanho, tipo, true, true));
            pedidos++;
            return roupaMap.get(chave);
        }
//        Retorna roupa que já está no cache
        return roupaMap.get(chave);
    }

//    Contabiliza o tamanho da fabrica pela quantidade de tipos de roupas
    public int getTamanhoFabrica() {
        int calca = 0, camisa = 0, blusa = 0, bermuda = 0, tamFab = 0;

        for (Map.Entry<String, Roupa> roupa : roupaMap.entrySet()) {

//            Contabiliza tipos de ropas, conforme solicitado no exercicio
            calca += roupa.getValue().getTipo() == "calca" ? 1 : 0;
            camisa += roupa.getValue().getTipo() == "camisa" ? 1 : 0;
            blusa += roupa.getValue().getTipo() == "blusa" ? 1 : 0;
            bermuda += roupa.getValue().getTipo() == "bermuda" ? 1 : 0;
        }

//        Soma ao tamanho ta fabrica os tipos de roupa que receberam pedidos
        tamFab += calca > 0 ? 1 : 0;
        tamFab += camisa > 0 ? 1 : 0;
        tamFab += blusa > 0 ? 1 : 0;
        tamFab += bermuda > 0 ? 1 : 0;

        return tamFab;
    }
}
