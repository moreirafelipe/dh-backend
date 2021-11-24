public class Main {

    public static void main(String[] args) {
//      Instancia objeto de verificação de artigos em cadeia
        CheckQuality tarefa = new CheckQuality();

//        Instancia artigos
        Artigo artigo1 = new Artigo("MonitorLed", 800, 800, "qualquer");
        Artigo artigo2 = new Artigo("Teclado Wireless", 1200, 1200, "qualquer");
        Artigo artigo3 = new Artigo("Teclado com fio", 1200, 1200, "saudavel");

//        Inicia verificação de cada artigo
        tarefa.checarArtigos(artigo1);
        tarefa.checarArtigos(artigo2);
        tarefa.checarArtigos(artigo3);
    }
}
