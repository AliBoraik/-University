import Models.Constant;
import Models.DataBase;
import java.sql.*;


public class TestJDBCHomeWork {
    public static void main(String[] args) throws SQLException {

        DataBase db = new DataBase("jdbc:postgresql://127.0.0.1:5432/uber2");
        db.setUserName("ali");
        db.setPassword("testpass");

        Connection connection = DriverManager.getConnection(db.getURL(), db.getUserName(), db.getPassword());

        Statement st = connection.createStatement();

        // create all tables in db
        createTables(st);
        // insert data to database
        insertData(st);

        selectData(st,"select * from car where car_id = 2");


        selectData(st,"select * from client where client_id = 2");

        st.close();
    }


    private static void createTables(Statement st) throws SQLException {
        // drop tables

        st.execute(Constant.DropTableStatement + "car,client,driver,trip");

        // car
        st.execute("create table car(car_id int not null primary key, model varchar,number_car varchar)");
        // client
        st.execute("create table client(client_id int not null primary key,name varchar(255) not null, phone varchar(15))");
        // driver
        st.execute("create table driver(driver_id int not null primary key, car_id int not null references car (car_id)," +
                "phone varchar(15),name varchar not null)");
        // trip
        st.execute("create table trip(trip_id int not null primary key,client_id int not null references client (client_id)," +
                "driver_id int not null references driver(driver_id),trip_date timestamp without time zone,trip_to varchar)");

    }

    private static void selectData(Statement st, String sqls) throws SQLException {

            ResultSet rs = st.executeQuery(sqls);
            ResultSetMetaData rsmd = rs.getMetaData();

            // counts all columns
            int columnsNumber = rsmd.getColumnCount();

            System.out.println("--------------------------------------");
            // print all columns name ...
            printColumnsName(rsmd);
            System.out.println("--------------------------------------");

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rs.getString(i) + "\t | ");
                }
                System.out.println();
            }
            System.out.println("----------------------------------------\n");
            rs.close();
    }

    private static void printColumnsName(ResultSetMetaData rsmd) throws SQLException {
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + " | ");
        }
        System.out.println();
    }

    private static void insertData(Statement st) throws SQLException {
        // car
        st.executeUpdate(Constant.InsertDataStatement +
                "car (car_id, model, number_car) values" +
                "(1, 'bmw', 'hh1231223')," +
                "(2, 'kai', 'HH343JJJ2'),(3, 'Toyota', '123456DD'), (4, 'Lada', '097DEFY')," +
                "(5, 'Kia Rio', 'TED3554'),(6, 'bmw m12', 'hh1231rgb'), (7, 'kai L1', 'HH343J4545')," +
                "(8, 'Toyota camry', '126DDgfE'),(9, 'Lada H1', '097DJFaked'), (10, 'Kia MM2', 'TEND0000')");

        // client
        st.executeUpdate(Constant.InsertDataStatement +
                "client (client_id, name, phone) values " +
                "(1, 'ALi', '896768594'),(2, 'Ahmed', '896768234'),(3, 'Evans', '876768556')," +
                "(4, 'Rehab', '845768594'),(5, 'Helm', '896764547'), (6, 'Kamil', '896767766'),(7, 'Soars', '896761122')," +
                "(8, 'Manoel', '876768556'),(9, 'khaled', '845768594'),(10, 'Keven', '896764547')");
        // driver
        st.executeUpdate(Constant.InsertDataStatement +
                "driver (driver_id, car_id, phone, name)" +
                "values (1, 3,'845678765', 'Evan'),(2, 2,'845672345', 'Denis')," +
                "(3, 4,'812345678', 'Kiril'),(4, 5,'809876543', 'Alas'),(5, 1,'865434567', 'Timor'),(6, 10,'84576854', 'Tom')," +
                "(7, 9,'845345466', 'Mark'),(8, 7,'824657686', 'Timo'),(9, 8,'896755446', 'Salah'),(10, 6,'8934453435', 'Marten')");
        // trip
        st.executeUpdate(Constant.InsertDataStatement +
                "trip (trip_id, client_id, driver_id, trip_date, trip_to) " +
                "values (1, 2, 2, '2021-03-12 09:53:21', 'kazan koalas 1'),(2, 3, 3, '2021-09-23 04:54:11', 'kazan koalas 12')" +
                ",(3, 6, 4, '2021-04-12 08:55:31', 'kazan center 1'),(4, 4, 5, '2021-07-21 11:52:21', 'kazan boshkna 12')," +
                "(5, 8, 10, '2021-09-05 12:14:31', 'kazan karla marks 5'),(6, 2, 7, '2020-11-08 09:54:48', 'kazan derive 2')," +
                "(7, 9, 8, '2020-04-06 08:55:43', 'kazan kolas 21'), (8, 3, 9, '2019-07-03 07:56:42', 'kazan center 2')" +
                ",(9, 10, 6, '2021-02-03 02:54:44', 'kazan bosh 01'),(10, 1, 1, '2020-03-23 03:44:42', 'kazan koalas 1')");

    }
}
