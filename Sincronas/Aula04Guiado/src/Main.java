public class Main {
    public static void main(String[] args) {
     CheckMail processo = new CheckMail();

     processo.verificarEmails( new Mail("email@email.com", "tecnica@digitalhouse.com", "Gerencia"));
     processo.verificarEmails( new Mail("email@email.com", "cddcsa@digitalhouse.com", "Reclamaçao"));
     processo.verificarEmails( new Mail("email@email.com", "cddcsa@digitalhouse.com", "Tecnico"));
     processo.verificarEmails( new Mail("email@email.com", "gerencia@colmeia.com", "Reclamação"));
     processo.verificarEmails( new Mail("email@email.com", "tecnica@digitalhouse.com", "Tecnico"));
     processo.verificarEmails( new Mail("email@email.com", "cddcsa@digitalhouse.com", "Reclamaçao"));
     processo.verificarEmails( new Mail("email@email.com", "cddcsa@digitalhouse.com", "Tecnico"));
     processo.verificarEmails( new Mail("email@email.com", "gerencia@colmeia.com", "Reclamação"));
    }
}
