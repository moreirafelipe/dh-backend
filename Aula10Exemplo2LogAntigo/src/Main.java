import org.apache.log4j.Logger;;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Leao leao = new Leao();
        leao.setIdade(15);
        leao.setNome("Simba");
        leao.seteAlfa(true);
        leao.correr();

        try {
            leao.eMaiorQue10();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Leao leao2 = new Leao();
        leao2.setIdade(-1);
        leao2.setNome("Mufasa");
        leao2.seteAlfa(false);
        leao2.correr();

        try {
            leao2.eMaiorQue10();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Tigre tigre = new Tigre();
        tigre.setIdade(8);
        tigre.setNome("Shino");
        tigre.correr();
    }
}
