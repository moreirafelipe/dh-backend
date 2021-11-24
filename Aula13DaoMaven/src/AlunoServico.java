import java.util.List;

public class AlunoServico {

    private IDAO<Aluno> alunoDAO;

    public AlunoServico() {

    }

    public AlunoServico( IDAO<Aluno> alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public void setAlunoDao( IDAO<Aluno> alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public Aluno salvarAluno(Aluno aluno){
        alunoDAO.salvar(aluno);
        return aluno;
    }

    public List<Aluno> buscarTodos(){
        return alunoDAO.buscarTodos();
    }

    public Aluno buscar(String id){
        return alunoDAO.buscar(id);
    }

    public void  eliminarAluno(String id){
        alunoDAO.eliminar(id);
    }
}
