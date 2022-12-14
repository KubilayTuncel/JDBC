import java.sql.Connection;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        Connection con = JdbcUtils.connectiontoDataBase("localhost","postgres","postgres","Koredeovarida1");
        Statement st = JdbcUtils.createStatemet();

        //JdbcUtils.execute("create table students(name varchar(20), id int, address varchar(50))");

        JdbcUtils.createTable("school","classes varchar(20)","teacher_name varchar(20)","id int");

        JdbcUtils.closeConAndSta();
    }
}
