public class ControlePeso extends Controladora {

    //    Implementa método abstrato que checa condição especifica da controladora
    @Override
    public void check(Artigo artigo) {
        if(artigo.getPeso() >= 1200 && artigo.getPeso() <= 1300) {
            System.out.println("Peso aceito!");
            artigo.setChecagens(true);
        } else if (this.getGerenciadorSeguinte() != null){
            System.out.println("Peso não aceito!");
            artigo.setChecagens(false);
        }
        this.getGerenciadorSeguinte().check(artigo);
    }
}
