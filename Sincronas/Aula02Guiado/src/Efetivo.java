public class Efetivo extends Funcionario{

    private double salarioBase;
    private double descontos;
    private double bonificacoes;

    public Efetivo(String nome, String sobrenome, String numConta, double salarioBase, double descontos,
                   double bonificacoes) {
        super(nome, sobrenome, numConta);
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.bonificacoes = bonificacoes;
    }


    @Override
    public double calcularPagamento() {
        return salarioBase + bonificacoes - descontos;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Foi gerado um recibo impresso na quantia de: " + quantia);
    }
}
