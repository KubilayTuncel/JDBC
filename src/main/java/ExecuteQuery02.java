import java.sql.*;

public class ExecuteQuery02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Koredeovarida1");

        Statement st = con.createStatement();

        //1.Örnek companies tab. en yüksek ikinci number_of_employees degeri olan company ve number_of_employees degerlerini bulunuz.

        ResultSet resultset1 = st.executeQuery("select company, number_of_employees from companies order by number_of_employees desc offset 1 row fetch next 1 row only");

        while (resultset1.next()){
            System.out.println(resultset1.getString(1)+ " "+ resultset1.getInt(2));
        }

        con.close();
        st.close();
        resultset1.close();
    }
}
