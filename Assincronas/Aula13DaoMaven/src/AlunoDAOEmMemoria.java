import java.util.List;

public class AlunoDAOEmMemoria implements IDAO<Aluno>{

    private List<Aluno> alunoRepositorio;

    public AlunoDAOEmMemoria(List<Aluno> alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }


    @Override
    public Aluno salvar(Aluno aluno) {
        alunoRepositorio.add(aluno);
        return aluno;
    }
    
    @Override
    public void eliminar(String id) {
        alunoRepositorio.removeIf(aluno -> aluno.getId().equals(id));
    }

    @Override
    public Aluno buscar(String id) {
        return alunoRepositorio.stream().filter(aluno ->
                aluno.getId().equals(id)).findFirst().orElseGet(null);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return alunoRepositorio;
    }
}
