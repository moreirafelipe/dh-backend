import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> sitesBloqueados = new ArrayList<>();

        sitesBloqueados.add("www.youtube.com");
        sitesBloqueados.add("www.facebook.com");

        IConexaoInternet proxy;
        proxy = new ProxyInternet(sitesBloqueados, new InternetService());

        proxy.conectarCom("www.google.com");
        proxy.conectarCom("www.youtube.com");

    }
}
