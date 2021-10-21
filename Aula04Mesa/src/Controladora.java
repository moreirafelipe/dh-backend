//Classe manipuladora que solicita os controles lote, peso e embalagem

public abstract class Controladora {

    protected Controladora gerenciadorSeguinte;

//    Define método a ser importado pelas classes controladoras
    public abstract void check(Artigo artigo);

//    Define modificadores de acesso
    public Controladora getGerenciadorSeguinte() {
        return gerenciadorSeguinte;
    }

    public void setGerenciadorSeguinte(Controladora gerenciadorSeguinte) {
        this.gerenciadorSeguinte = gerenciadorSeguinte;
    }
}
