import org.apache.log4j.Logger;

public class DAO {

    private static final Logger logger = Logger.getLogger(DAO.class);

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS PACIENTE;" +
            "CREATE TABLE PACIENTE(" +
            "ID INT PRIMARY KEY, " +
            "NOME varchar(100) NOT NULL," +
            "SOBRENOME varchar(100) NOT NULL)" +
            "ENDERECO varchar(100) NOT NULL)" +
            "RG varchar(50) NOT NULL)" +
            "DATA_CADASTRO varchar(10) NOT NULL)" +
            "NOME_USUARIO varchar(100) NOT NULL)" +
            "SENHA varchar(100) NOT NULL)";

    private static final String SQL_INSERT =
            "INSERT INTO FUNCIONARIOS   (ID,NOME, NOME, SOBRENOME, ENDERECO, RG, DATA_CADASTRO, NOME_USUARIO, SENHA)" +
                                        "VALUES (1,'Felipe', 'Oliveira', 'Rua oito', '99999999-99', 2021-10-30, 'felipe21', 'senha123')";

    public static void main(String[] args) {

    }
}
