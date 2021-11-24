import dto.Arvore;
import factory.ArvoreFactory;

public class Main {
    public static void main(String[] args) {
        ArvoreFactory floresta = new ArvoreFactory();

        Arvore ornamental = floresta.getArvore(200,400, "verde", "ornamental");
        Arvore frutifera = floresta.getArvore(500,300, "vermelha", "frutifera");
        Arvore florifera = floresta.getArvore(100,200, "azul", "florifera");

        System.out.println("\nAntes do Burnout\n");

        //Checando memoria antes da execução
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

        System.out.println("\nInicio do Burnout\n");

        //Testando criacao de 1000000 de arvores
        for(int i = 0; i < 1000000 ; i++) {
            //Define metade das arvores como verdes
            if(i < 500000) {
                floresta.getArvore(200,400, "verde", "ornamental");
            } else {
                //Outra metade como arvores vermelhas
                floresta.getArvore(200,400, "vermelha", "frutifera");
            }
        }
        //Checando memoria após a execução
        runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
