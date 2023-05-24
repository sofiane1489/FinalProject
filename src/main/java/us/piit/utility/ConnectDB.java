package us.piit.utility;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDB {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    static Properties prop = Utility.loadProperties();

    public static Connection connectToSqlDatabase() {
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        try {
            Class.forName(driverClass);
            connect = DriverManager.getConnection(url,userName,password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Database is connected");
        return connect;
    }

    public static MongoDatabase mongoDatabase = null;

    public MongoDatabase connectToMongoDB() {
        MongoClient mongoClient = new MongoClient("" , 27017);
        mongoDatabase = mongoClient.getDatabase("");
        System.out.println("Database Connected");

        return mongoDatabase;
    }

    public static List<String> getTableColumnData(String query, String columnName) {
        List<String> list = new ArrayList<>();
        try {
            statement = connectToSqlDatabase().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                list.add(resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //............................data insertion..............................

    public static void insertData(String tableName, List<Object> values) {
        try {
            connect = connectToSqlDatabase();
            StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
            int numValues = values.size();
            for (int i = 0; i < numValues; i++) {
                query.append("?");
                if (i < numValues - 1) {
                    query.append(",");
                }
            }
            query.append(")");

            ps = connect.prepareStatement(query.toString());

            for (int i = 0; i < numValues; i++) {
                Object value = values.get(i);
                if (value instanceof Integer) {
                    ps.setInt(i + 1, (Integer) value);
                } else {
                    ps.setString(i + 1, value.toString());
                }
            }

            ps.executeUpdate();

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnections();
        }
    }


    //.......................................................

    public static void closeConnections() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//.................................................................................

    public static void main(String[] args) throws SQLException {


        //ArrayList called values that can hold objects of type Object.
        List<Object> values = new ArrayList<>();
//        values.add(" ");
//        values.add(" ");
//        values.add("3.Enter the URL and click search");
//        values.add("\"user lands to luma home page \n" + " title\"\"Home Page\"\"\"");
//        values.add("passed");
//        values.add(" ");
//        values.add("Sofiane Sehad/Sofiane Sehad");
//        values.add(" ");
//        values.add(" ");
//        String tableName = "lumaTestCases";

//        values.add(3);
//        values.add("Jack");
//        values.add("Arranda");
//        values.add("JackArranda@tester.com");
//        values.add(1966503348);
//         String tableName = "Testers";

//        //data insertion
//        insertData(tableName, values);




        //reading data
         List<String> emails = getTableColumnData("select * from Testers;","Email");
         for(int i=0;i<=1;i++) {
            System.out.println(emails.get(i));
        }

    }
}
