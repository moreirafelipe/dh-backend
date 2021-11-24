package dao;

public interface IDao <T>{
    T salvar(T t);
    T buscar(Integer t);
    void buscarTodos();
    void deletar(T t);
    T modificar(T t);
}
