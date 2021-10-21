public class CheckQuality {

    Controladora inicial;

    public CheckQuality() {

//        Define controle inicial
        this.inicial = new ControleLote();

        Controladora peso = new ControlePeso();
        Controladora embalagem = new ControleEmbalagem();

//        Atribui os controles seguintes a serem acionados por cada controle em cadeia
        inicial.setGerenciadorSeguinte(peso);
        peso.setGerenciadorSeguinte(embalagem);
    }

//    Método de verificação da classe solicitado pela classe main
    public void checarArtigos(Artigo artigo) {
        System.out.println("\nRELATÓRIO DE CHECAGEM");
        System.out.println("Artigo: " + artigo.getNome());
        inicial.check(artigo);
    }
}
