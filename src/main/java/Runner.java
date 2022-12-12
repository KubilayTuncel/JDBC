import java.sql.Connection;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        Connection con = JdbcUtils.connectiontoDataBase();
        Statement st = JdbcUtils.createStatemet();
    }
}
