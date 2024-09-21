import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL_Connection

{
    public Connection con;
    private final String DRIVER = "com.mysql.jdcb.Driver";
    private final String DB_Name = "locadora";
    private final String DB = "jdbc:mysql://localhost:3306/" + DB_Name;
    private final String USER = "root";
    private final String PASSWORD = "a senha do MYSQL"; // usar o vault para acessar senhas

    // Behaviours
    public boolean getConnection() throws ClassNotFoundException

    {
        try

        {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(DB, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso: ");
            return true;
        }

        catch (SQLException e)

        {
            System.out.println("Problema com a conexão com o banco de dados" + e.getMessage());
        }
        return true;
    }

    public void closeConnection() {
        try

        {
            con.close();
        }

        catch (SQLException e)

        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("Usuário desconectado!");
    }

}
