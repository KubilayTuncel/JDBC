import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test01 {

    @Test
    public void test01() throws SQLException {
         /*
        Given
          User connects to the database

        When
          User sends the query to get the region ids from "countries" table

        Then
          Assert that the number of region ids greater than 1 is 17.

        And
          User closes the connection
       */

        JdbcUtils.connectiontoDataBase("localhost","postgres","postgres","Koredeovarida1");
        Statement st = JdbcUtils.createStatemet();

        String sql1= "select region_id from countries";

        ResultSet resultSet1 = st.executeQuery(sql1);
        List<Integer> ids= new ArrayList<>();
        List<Integer> idsGreaterThan1 = new ArrayList<>();
        while (resultSet1.next()){
            ids.add(resultSet1.getInt(1));

        }
        for (int w:ids) {

            if (w>1){
                idsGreaterThan1.add(w);
            }

        }

        assertEquals(17,idsGreaterThan1.size());

        JdbcUtils.closeConAndSta();

    }
}
