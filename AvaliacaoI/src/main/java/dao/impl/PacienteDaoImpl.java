package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static dao.impl.EnderecoDaoImpl.log;

public class PacienteDaoImpl implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;
    private EnderecoDaoImpl enderecoDao;

    public PacienteDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDao = new EnderecoDaoImpl();
    }

    @Override
    public Paciente adicionar(Paciente paciente) {
        log.debug("Cadastrando um novo paciente: " + paciente.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("INSERT INTO pacientes(nome,sobrenome,rg,dataCadastro,endereco_id) VALUES('%s','%s','%s','%s','%s')",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getRg(),
                paciente.getDataCadastro(),
                paciente.getEndereco().getId());

        try{
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if(keys.next()){
                paciente.setId(keys.getInt(1));
                statement.close();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        log.debug("Consultando paciente ID: " + id);
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        Paciente paciente = null;

        String query = String.format("SELECT * FROM pacientes WHERE id = '%s'", id);

        try{
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next())
                paciente = criarObjetoPaciente(result);
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;

    }

    @Override
    public Paciente buscarTodos() {
        return null;
    }

    @Override
    public Paciente atualizar(Integer id) {
        return null;
    }

    @Override
    public Paciente apagar(Integer id) {
        return null;
    }

    private Paciente criarObjetoPaciente(ResultSet result) throws SQLException {
        Integer idPaciente = result.getInt("id");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String rg = result.getString("rg");
        Date dataDeCadastro = result.getDate("dataDeCadastro");
        Endereco endereco = enderecoDao.buscar(result.getInt("enderecoId")).orElse(null);
        return new Paciente(idPaciente, nome, sobrenome, rg, dataDeCadastro, endereco);
    }
}