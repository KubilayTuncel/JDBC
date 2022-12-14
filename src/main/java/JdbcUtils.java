import java.sql.*;

public class JdbcUtils {
    private static Connection connection;
    private static Statement statement;

    public static Connection connectiontoDataBase(String hostName, String dbName,String userName, String password) {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://"+hostName+":5432/"+dbName,userName,password);
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

    public static boolean execute(String sql){
        boolean isExecute;
        try{
            isExecute = statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isExecute;
    }

    public static void closeConAndSta() {
        try {
            connection.close();
            statement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        try{
            if(connection.isClosed()&&statement.isClosed()){
                System.out.println("Connection and Statement is closed");
            }else {
                System.out.println("Connection and Statement is NOT closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createTable(String tableName, String... columnName_dataType)  {

        java.lang.StringBuilder columnName_dataValue = new java.lang.StringBuilder("");


        for(String w : columnName_dataType) {

            columnName_dataValue.append(w).append(",");

        }
        columnName_dataValue.deleteCharAt(columnName_dataValue.length()-1);
        // 2. yol
        //columnName_dataValue.deleteCharAt(columnName_dataValue.lastIndexOf(","));

        try {
            statement.execute("create table "+tableName+"("+columnName_dataValue+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
