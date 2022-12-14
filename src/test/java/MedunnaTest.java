import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunnaTest {

    @Test
    public void test01() throws SQLException {
        /*
   Given
     User connects to the database
     (Host name: medunna.com, Database name: medunna_db, Usename: medunna_user, Password: medunna_pass_987))
   When
     User sends the query to get the names of created_by column from "room" table
   Then
     Assert that there are some rooms created by "john_doe".
   And
     User closes the connection
  */
        JdbcUtils.connectiontoDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
        Statement statement = JdbcUtils.createStatemet();

        String sql1 = "select created_by from room ";

        ResultSet resultSet1 = statement.executeQuery(sql1);
        List<String> created_byList = new ArrayList<>();
        while (resultSet1.next()) {
             created_byList.add( resultSet1.getString(1));
        }

        Assert.assertTrue(created_byList.contains("john_doe"));

        JdbcUtils.closeConAndSta();
    }
}
