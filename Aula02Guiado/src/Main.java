public class Main {

    public static void main(String[] args) {
        Efetivo funcionario = new Efetivo("Felipe", "Oliveira", "000001", 5000.00, 1000, 500);
        funcionario.pagamentoSalario();
        funcionario.calcularPagamento();
    }
}
