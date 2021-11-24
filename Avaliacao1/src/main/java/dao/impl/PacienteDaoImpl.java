package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class PacienteDaoImpl implements IDao <Paciente> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(PacienteDaoImpl.class);

    public PacienteDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        log.debug("Registrando um novo paciente: " + paciente.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("INSERT INTO paciente(nome, sobrenome, rg, dataCadastro, enderecoId) VALUES('%s','%s','%s','%s','%s')",
                paciente.getNome(), paciente.getSobrenome(), paciente.getRg(), paciente.getDataCadastro(), paciente.getEndereco().getId());
        try {
           statement = connection.createStatement();
           statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
           ResultSet keys = statement.getGeneratedKeys();
           if (keys.next())
               paciente.setId(keys.getInt(1));
           statement.close();
           connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        log.debug("Buscar paciente: " + id);

        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM paciente WHERE id=%s", id);
        Paciente paciente = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()){
                String queryEndereco = String.format("SELECT * FROM endereco WHERE id=%s",rs.getInt("enderecoId"));
                Statement statementEndereco = connection.createStatement();
                ResultSet rsEndereco = statementEndereco.executeQuery(queryEndereco);
                Endereco endereco = null;
                if (rsEndereco.next()) {
                    endereco = new Endereco(
                            rsEndereco.getInt("id"),
                            rsEndereco.getString("rua"),
                            rsEndereco.getInt("numero"),
                            rsEndereco.getString("cidade"),
                            rsEndereco.getString("estado")
                    );
                }
                paciente = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("rg"),
                        LocalDate.parse(rs.getString("dataCadastro")),
                        endereco
                );
                statementEndereco.close();

            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void buscarTodos() {}

    @Override
    public void deletar(Paciente paciente) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("DELETE FROM PACIENTE WHERE id=%s", paciente.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        return null;
    }
}
