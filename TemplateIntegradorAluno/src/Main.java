public class Main {
    public static void main(String[] args) {
        /*Mofidicar o main para testar a lógica com o template method */
        Funcionario func1 = new Funcionario("Pedro",2); func1.vender(2);
        Funcionario func2 = new Funcionario("Maria",1); func2.vender(1);

        Vendedor afi1 = new Afiliado("Ramon"); afi1.vender(4);
        Vendedor afi2 = new Afiliado("Paulo"); afi2.vender(1);
        Vendedor afi3 = new Afiliado("José");

        Vendedor est1 = new Estagiario("Carlos"); est1.vender(10);
        Vendedor est2 = new Estagiario("Fernanda"); est2.vender(5);

        func1.addAfiliado(afi1);

        System.out.println(func1.mostrarCategoria());
        System.out.println(func2.mostrarCategoria());
        System.out.println(afi1.mostrarCategoria());
        System.out.println(est1.mostrarCategoria());
        System.out.println(est2.mostrarCategoria());
    }
}
