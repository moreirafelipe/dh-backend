import java.util.List;

public interface IDAO<T> {
    public T salvar(T t);
    public void eliminar(String id);
    public T buscar(String id);
    public List<T> buscarTodos();
}
