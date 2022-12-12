import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    private static Connection connection;
    private static Statement statement;

    public static Connection connectiontoDataBase() {
        try{
            Class.forName("org.postgrsql.Driver");
        } catch (ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Koredeovarida1");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        if (connection!=null){
            System.out.println("Connection Success");
        }else{
            System.out.println("Connection Fail");
        }

        return connection;
    }

    public static Statement createStatemet(){
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return statement;
    }
}
