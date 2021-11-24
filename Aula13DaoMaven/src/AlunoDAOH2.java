import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOH2 implements IDAO<Aluno>{

    private ConfigurationJDBC configurationJDBC;

    public AlunoDAOH2(ConfigurationJDBC configurationJDBC) {

        this.configurationJDBC = configurationJDBC;

    }

    @Override
    public Aluno salvar(Aluno aluno) {
        Connection connection = configurationJDBC.conectarBancoDeDados();

        Statement stmt = null;

        String query = String.format("INSERT INTO Aluno VALUES('%s','%s','%s')", aluno.getId(), aluno.getNome(), aluno.getApelido());

        try {

            stmt = connection.createStatement();

            stmt.executeUpdate(query);

            stmt.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        return aluno;
    }

    @Override
    public void eliminar(String id) {
        Connection connection = configurationJDBC.conectarBancoDeDados();

        Statement stmt = null;

        String query = String.format("DELETE FROM Aluno where id = %s", id);

        try {

            stmt = connection.createStatement();

            stmt.executeUpdate(query);

            stmt.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    @Override
    public Aluno buscar(String id) {
        Connection connection = configurationJDBC.conectarBancoDeDados();

        Statement stmt = null;

        String query = String.format("SELECT id, nome, apelido  FROM Aluno where id = '%s'", id);

        Aluno aluno = null;

        try {

            stmt = connection.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {

                String idAluno = result.getString("id");

                String nome = result.getString("nome");

                String apelido = result.getString("apelido");

                aluno = new Aluno(idAluno, nome, apelido);

            }



            stmt.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        return aluno;
    }

    @Override
    public List<Aluno> buscarTodos() {
        Connection connection = configurationJDBC.conectarBancoDeDados();

        Statement stmt = null;

        String query = "SELECT *  FROM Aluno";

        List<Aluno> aluno = new ArrayList<>();

        try {

            stmt = connection.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {

                String id = result.getString("id");

                String nome = result.getString("nome");

                String apelido = result.getString("apelido");

                aluno.add(new Aluno(id, nome, apelido));

            }

            stmt.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        return aluno;
    }
}
