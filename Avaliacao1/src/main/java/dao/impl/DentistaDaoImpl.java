package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Dentista;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class DentistaDaoImpl implements IDao<Dentista> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(EnderecoDaoImpl.class);

    public DentistaDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        log.debug("Registrando um novo dentista: " + dentista.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("INSERT INTO dentista(numeroMatricula, nome, sobrenome) VALUES('%s','%s','%s')",
                dentista.getNumeroMatricula(), dentista.getNome(), dentista.getSobrenome());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                dentista.setId(keys.getInt(1));
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dentista;
    }

    @Override
    public Dentista buscar(Integer t) {
        return null;
    }

    @Override
    public void buscarTodos() {
        log.debug("Listando todos os dentistas:");

        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM dentista");
        Dentista dentista = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                log.info("Código numérico: " + rs.getInt(1) + " | Nome: " + rs.getString(2) + " | Sobrenome: " + rs.getString(3));
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Dentista dentista) {

    }

    @Override
    public Dentista modificar(Dentista dentista) {
        return null;
    }
}
