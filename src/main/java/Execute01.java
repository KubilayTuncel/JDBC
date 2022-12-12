import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

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

       //4. Adim. Query calistir

        /*
        execute() methodu DDL(create, drop, alter table) ve DQL (select) icin kullanilabilir.
        1) Eger bu execute() methodu DDL icin kullanilirsa false return yapar.
        2)Eger execute()  meth. DQL icin kullanilirsa ResultSet alindiginda true aksi halde false verir.
                 */
        //1. Örnek "workers" adinda bir table olusturun. "worker_id, worker_name, worker_salary" kolonlarjni olsuturun.

       boolean sql1= st.execute("create table workers (worker_id varchar(20), worker_name varchar(30), worker_salary int )");
       //Burada bir database olusturma isleminden sonra bu boolean i yazmamizin nedeni table i olusturdugumuzu görmek
        System.out.println("sql1 = " +sql1); //false return eder cünkü data cagiramiyoruz.

        //2. Örnek TAble'a worker_adress sutunu ekleyerek alter yapin
        String sql2="alter table workers add worker_address varchar(80)";
        boolean sql2b = st.execute(sql2);
        System.out.println("sql2 = " + sql2b);

        //3.Örnek workers table'ini silin

        String sql3="drop table workers";
        st.execute(sql3);

       //5. Adim Baglanti ve Statement'i kapat.
        con.close();
        st.close();
    }
}
