public class ControleEmbalagem extends Controladora {

    //    Implementa método abstrato que checa condição especifica da controladora
    @Override
    public void check(Artigo artigo) {

        int aceito = 0, rejeitado = 0;

        if(artigo.getEmbalagem().equalsIgnoreCase("saudavel") ||
                artigo.getEmbalagem().equalsIgnoreCase("quase saudavel")) {
            System.out.println("Embalagem aceita!");
            artigo.setChecagens(true);
        } else {
            System.out.println("Embalagem não aceita!");
            artigo.setChecagens(false);
        }

        for(int i = 0; i < artigo.checagens.size(); i++) {
            if(artigo.checagens.get(i) == true) aceito++;
           if(artigo.checagens.get(i) == false) rejeitado++;
        }

        //Verifica situação geral da tarefa de checagem no último estágio de verificação, conforme solicitado no
        // documento de requisitos

        if(aceito == 3)
            System.out.println("\nSITUAÇÃO: Produto aceito!");
        else if(rejeitado == 3)
            System.out.println("\nSITUAÇÃO: Produto rejeitado!");
        else
            System.out.println("\nSITUAÇÃO: Atribuição parcial de resultados!");
    }
}
