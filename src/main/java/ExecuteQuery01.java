import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //maven repository'den jdbc postgres dependicies yükledim.
        //1. Adim : driver a kaydol.

        Class.forName("org.postgresql.Driver");

        //2.Adim: Database'e baglan.
        //Burada database baglanirken user a kadar olan ksim geneld ayni ama son kisimda yazdigimiz postgres baglandigimiz
        //database'in adi bu önemli.
        //sonrasi username ve password benim belirledigim.

        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Koredeovarida1");

        //3. Adim Statement olustur.

        Statement st = con.createStatement();

        String sql1=" select country_name from countries where region_id=1";
        boolean r1 = st.execute(sql1);

        System.out.println("r1 :" +r1);

        //Recordlari görmek executequery methodunu kullanmamiz gerekiyor.

        ResultSet resultSet1 = st.executeQuery(sql1);

        while (resultSet1.next()) {
            String ülke= resultSet1.getString("country_name");  //yada country_name in colunms sirasini yazabiliriz. oda 1. Cünkü adece country_name i cagirdik.
            // yani resultSet1.getString(1) gibi yazabiliriz.
            System.out.println(ülke);
        }

        //2. Örnek : regio_id'nin 2 den büyük oldugu ülkeleri bulunuz

        String sql2 = "select country_id, country_name from countries where region_id > 2";
        boolean r2 = st.execute(sql2);

        ResultSet resultSet2 = st.executeQuery(sql2);

        while (resultSet2.next()) {
            System.out.println(resultSet2.getString("country_id") + " " + resultSet2.getString("country_name"));
        }

        System.out.println("örnek 3 ----------*******--------");
        //3. Örnek number_of_employees degeri en düsük olan satirin tüm degerlerini cagirin.

        String sql3 = "select * from companies where number_of_employees = (select min(number_of_employees) from companies) ";

        ResultSet resultSet3 = st.executeQuery(sql3);

        while (resultSet3.next()) {
            System.out.println(resultSet3.getInt(1)+ " "+ resultSet3.getString(2)+ " "+resultSet3.getString(3));
        }



    }
}
