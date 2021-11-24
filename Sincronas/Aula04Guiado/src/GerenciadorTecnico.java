public class GerenciadorTecnico extends Gerenciador{

    @Override
    public void verificar(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("tecnico@colmeia.com") ||
                (mail.getAssunto().equalsIgnoreCase("Tecnico"))) {
            System.out.println("Enviado ao depatramento tecnico");
        } else {
            if(this.getGerenciadorSeguinte() != null) {
                this.getGerenciadorSeguinte().verificar(mail);
            }
        }
    }
}
