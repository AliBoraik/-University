package ru.itis.models;

import ru.itis.annotations.Component;
import ru.itis.annotations.Inject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


@Component
public class ComparisonDB {

    @Inject
    private DataBase db;

    @Inject
    private ScanEntity scanEntity;


    public void startComparing() {


        Connection conn = db.getConnection();


        try {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(Scripts.sqlTables);

            while (rs.next()) {

                String tableName = rs.getString(1);

                if (scanEntity.getAllEntities().containsKey(tableName)) {
                    System.out.println("Table : ( " + tableName + " ) found !");

                    List<String> entityFields = scanEntity.getAllEntities().get(tableName);

                    ResultSet f = conn.createStatement().executeQuery(String.format(Scripts.sqlFields, tableName));

                    List<String> dbFields = new LinkedList<>();

                    while (f.next()) {
                        String nameColumnDb = f.getString(1);
                        dbFields.add(nameColumnDb);
                    }


                    entityFields.forEach( eField -> {
                        String massage = dbFields.contains(eField)
                                ? "\t column : ( " + eField + " ) compatible with databases column."
                                : "\t column : ( " + eField + " ) not compatible with databases column!!";
                        System.out.println(massage);
                    });

                }
            }
            rs.close();
            statement.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
