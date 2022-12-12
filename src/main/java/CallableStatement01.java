import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Koredeovarida1");

        Statement st = con.createStatement();

        /*
        Java'da methodlar return type sahibi olsa da olmasa da method olarak adlandirilir.
        SQL'de ise data return ediyorsa funciton denir. REturn yapmiyorsa precedure olarak adlandirilir.
         */

        //CallableStatement ile function cagirmayi parametrelendirecegiz.
        //1.Adim function kodunu yaz.
        String sql1 = "Create or replace function toplamaF (x numeric, y numeric)\n" +
                "returns numeric\n" +
                "language plpgsql\n" +
                "as\n" +
                "$$\n" +
                "Begin\n" +
                "return x+y;\n" +
                "end\n" +
                "$$";
        //2. Adim function calistir.
        st.execute(sql1);

        //3. Adim: function cagir.
        CallableStatement cst1 = con.prepareCall("{? = call toplamaF(?,?)}");

        //data type SQL den java ya dönüs icin link https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
        // 4. Adim: Return icin registerOutParameter() methodunu. parametreler icin ise set() methodlarini kullanacagiz
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,6);
        cst1.setInt(3,4);

        //5. Adim execute() methodu ile CallabStatement calistir.
        cst1.execute();

        //6. Adim: Sonucu cagirmak icin return datatype a gore

        System.out.println(cst1.getBigDecimal(1));

        //1. adim
        String sql2 = "Create or replace function konininHacmi (r numeric, h numeric)\n" +
                "returns numeric\n" +
                "language plpgsql\n" +
                "as\n" +
                "$$\n" +
                "Begin\n" +
                "return 3.14*r*r*h/3;\n" +
                "end\n" +
                "$$";

        st.execute(sql2);

        CallableStatement cst2 = con.prepareCall("{? = call konininHacmi(?,?)}");

        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,6);

        cst2.execute();

        System.out.printf("%.2f",cst2.getBigDecimal(1));

        con.close();
        st.close();
        cst1.close();
        cst2.close();

    }
}
