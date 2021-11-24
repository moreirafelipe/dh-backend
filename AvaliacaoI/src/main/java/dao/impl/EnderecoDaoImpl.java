package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EnderecoDaoImpl implements IDao<Endereco> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(EnderecoDaoImpl.class);

    public EnderecoDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Endereco adicionar(Endereco endereco) {

        log.debug("Cadastrando um novo endereço: " + endereco.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("INSERT INTO ENDERECOS(rua,numero,cidade,estado) VALUES('%s','%s','%s','%s')",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado());

        try{
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if(keys.next()){
                endereco.setId(keys.getInt(1));
                statement.close();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Endereco buscar(Integer id) {
        return null;
    }

    @Override
    public Endereco buscarTodos() {
        return null;
    }

    @Override
    public Endereco atualizar(Integer id) {
        return null;
    }

    @Override
    public Endereco apagar(Integer id) {
        return null;
    }
}
