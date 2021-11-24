import model.Ip;
import service.impl.GradeDeFilmesProxy;
import service.impl.GradeDeSeriesProxy;
import service.IGradeDeFilmes;
import service.ISerie;

public class Main {
    public static void main(String[] args) {

        IGradeDeFilmes pedido1 = new GradeDeFilmesProxy(new Ip(50, 255,255,255));
        ISerie pedido2 = new GradeDeSeriesProxy(new Ip(49, 255,255,255));

        System.out.println("SOLICITA FILMES");

        pedido1.getFilme("Matrix 1");
        pedido1.getFilme("Matrix 2");
        pedido1.getFilme("Matrix 3");
        pedido1.getFilme("Matrix 4");

        System.out.println("\nSOLICITA SÉRIES\n");

        pedido2.getSerie("The Office"); //Exibe link
        pedido2.getSerie("Mr Robot 2"); //Série não cadastrada no páis do ip proxy cliente
        pedido2.getSerie("Mr Robot"); //Exibe link
        pedido2.getSerie("Mr Robot"); //Exibe link
        pedido2.getSerie("Mr Robot"); //Exibe link
        pedido2.getSerie("Mr Robot"); //Exibe link
        pedido2.getSerie("The Office"); //Limite atingido
        pedido2.getSerie("The Office"); //Limite atingido
    }
}
