import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;;

public class Main {

   //instancia objeto de log
    private static final Logger logger = Logger.getLogger(Main.class);

    //Inicia queries
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS FUNCIONARIOS;" +
            "CREATE TABLE FUNCIONARIOS(" +
            "ID INT PRIMARY KEY, " +
            "NOME varchar(100) NOT NULL," +
            "EMAIL varchar(100) NOT NULL)";

    public static void main(String[] args){

//        Simulando um arquivo JSON para automação de script
        Map<String, String> script = new HashMap<>() {{
            put("INSERT INTO FUNCIONARIOS (ID,NOME, EMAIL) VALUES (1,'William', 'william@email.com')", "Funcionário inserido com sucesso!" );
            put("INSERT INTO FUNCIONARIOS (ID,NOME, EMAIL) VALUES (2,'Juliana', 'juliana@email.com')", "Funcionário inserido com sucesso!");
            put("INSERT INTO FUNCIONARIOS (ID,NOME, EMAIL) VALUES (1,'Julia', 'julia@email.com')","Funcionário inserido com sucesso!");
            put("INSERT INTO FUNCIONARIOS (ID,NOME, EMAIL) VALUES (3,'Felipe', 'felipe@email.com')", "Funcionário inserido com sucesso!");
            put("UPDATE FUNCIONARIOS SET EMAIL='felipeoliveira@gmail.com' WHERE ID=3", "Dados do funcionário ID = 3 atualizados!");
            put("DELETE FROM FUNCIONARIOS WHERE ID=1", "Funcionário(a) William excluido(a) com sucesso!");
            put("DELETE FROM FUNCIONARIOS WHERE EMAIL='juliana@email.com'", "Funcionário(a) Juliana excluido(a) com sucesso!");
        }};

        Connection connection;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            logger.info("Tabela criada!");

//            Executando funções de automação e consulta de dados
            automateQueries(connection, statement, script);
            consultaFuncionario(connection);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            logger.info("Script executado com sucesso!");
        }
    }

    public static void automateQueries(Connection connection, Statement statement, Map<String, String> script) throws Exception {

//        Inicia Execução de comandos SQL a cada elemento do arquivo JSON simulado
        for(Map.Entry<String, String> entry : script.entrySet()) {
            try {
                connection = getConnection();
                statement.execute(entry.getKey());
                logger.info(entry.getValue());
            } catch (Exception e) {
                logger.error(e);
            } finally {
                connection.close();
            }
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

//    retorna último registro do BD restante após passar pela exceção “Unique index or primary key violation”
    public static void consultaFuncionario(Connection connection) throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIOS";
        Statement sqlSmt = connection.createStatement();
        ResultSet rs = sqlSmt.executeQuery(sql);

        System.out.println("\nRegistros atuais:");

        while(rs.next()){
            logger.info(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
}