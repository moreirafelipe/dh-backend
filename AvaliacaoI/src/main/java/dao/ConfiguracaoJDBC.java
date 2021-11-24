package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    private static final String SQL_CREATE_TABLE1 = "create table IF NOT EXISTS pacientes " +
            "(" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nome VARCHAR(20) NOT NULL, " +
            "sobrenome VARCHAR(20) NOT NULL, " +
            "rg VARCHAR(11)  NOT NULL, " +
            "dataCadastro DATE  NOT NULL, " +
            "endereco_id INT NOT NULL, " +
            "FOREIGN KEY (endereco_id) REFERENCES enderecos(id)" +
            ")";

    private static final String SQL_CREATE_TABLE2 = "create table IF NOT EXISTS enderecos " +
            "(" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "rua VARCHAR(100)  NOT NULL, " +
            "numero VARCHAR(20)  NOT NULL, " +
            "cidade VARCHAR(50)  NOT NULL, " +
            "estado CHAR(2)  NOT NULL" +
            ")";

    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.nomeUsuario = "sa";
        this.senha = "";

        criarTabela();
    }

    private void criarTabela(){
        try{
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE1);
            statement.execute(SQL_CREATE_TABLE2);
            statement.close();
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Connection conectarBanco(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
