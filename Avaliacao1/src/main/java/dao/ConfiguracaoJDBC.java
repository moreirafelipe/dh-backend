package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    private static final String SQL_CREATE_TABLE1 = "DROP TABLE IF EXISTS PACIENTE CASCADE; CREATE TABLE PACIENTE " +
            "(" +
            "id int auto_increment primary key, " +
            "nome varchar(100), " +
            "sobrenome varchar(100), " +
            "rg varchar(20), " +
            "dataCadastro date, " +
            "enderecoId int, " +
            "foreign key (enderecoId) references endereco(id))";

    private static final String SQL_CREATE_TABLE2 = "DROP TABLE IF EXISTS ENDERECO CASCADE; CREATE TABLE ENDERECO " +
            "(" +
            "id int auto_increment primary key, " +
            "rua varchar(100), " +
            "numero tinyint, " +
            "cidade varchar(100), " +
            "estado varchar(100))";

    private static final String SQL_CREATE_TABLE3 = "DROP TABLE IF EXISTS DENTISTA CASCADE; CREATE TABLE DENTISTA " +
            "(" +
            "numeroMatricula int auto_increment primary key, " +
            "nome varchar(20), " +
            "sobrenome varchar(50))";

    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

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
            statement.execute(SQL_CREATE_TABLE3);

            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection conectarBanco(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }






}
