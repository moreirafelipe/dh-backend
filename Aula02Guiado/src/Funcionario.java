public abstract class Funcionario {

    private String nome;
    private String sobrenome;
    private String numConta;

    public Funcionario(String nome, String sobrenome, String numConta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numConta = numConta;
    }

    public void pagamentoSalario() {
        double quantia;
        quantia = calcularPagamento();
        imprimirRecibo(quantia);
        depositar(quantia);
    }

    public abstract double calcularPagamento();
    public abstract void imprimirRecibo(double quantia);
    public void depositar(double quantia){
        System.out.println("Foi depositado uma quantia de: " + quantia + " na conta " + numConta);
    }
}
