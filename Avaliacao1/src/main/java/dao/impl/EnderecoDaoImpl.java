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
    public Endereco salvar(Endereco endereco) {
        log.debug("Salvando um endereco: " + endereco.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("INSERT INTO endereco(rua, numero, cidade, estado) VALUES('%s','%s','%s','%s')",
                endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado());

        try {
            statement = connection.createStatement();
            //RETURN_GENERATED_KEYS retorna o ID auto gerado no BD e atribui ao objeto em memórioa ao executar a query
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            //Retorna as chaves geradas
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                //Define o ID para o ogjeto endereço a partir do valor da coluna 1 do registro retornado como Int
                endereco.setId(keys.getInt(1));
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Endereco buscar(Integer id) {
        return null;
    }

    @Override
    public void buscarTodos() {}

    @Override
    public void deletar(Endereco endereco) {
    }

    @Override
    public Endereco modificar(Endereco endereco) {
        return null;
    }
}
