public class ControleLote extends Controladora {

//    Implementa método abstrato que checa condição especifica da controladora
    @Override
    public void check(Artigo artigo) {
        if(artigo.getLote() >= 1000 && artigo.getLote() <= 2000) {
            System.out.println("Lote aceito!");
            artigo.setChecagens(true);
        } else if (this.getGerenciadorSeguinte() != null){
            System.out.println("Lote não aceito!");
            artigo.setChecagens(false);
        }
        this.getGerenciadorSeguinte().check(artigo);
    }
}
