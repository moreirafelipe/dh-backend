package dao;

import model.Endereco;
import model.Paciente;

public interface IDao<T> {
    public T adicionar(T t);
    public T buscar(Integer id);
    public T buscarTodos();
    public T atualizar(Integer id);
    public T apagar(Integer id);
}
