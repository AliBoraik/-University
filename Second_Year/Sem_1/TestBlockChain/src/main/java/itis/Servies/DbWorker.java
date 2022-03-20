package itis.Servies;


import itis.Model.BlockModel;

import java.sql.Connection;
import java.sql.SQLException;

public class DbWorker {
    private Connection connection;

    public DbWorker() {
        DataBase.getInstance();
        connection = DataBase.getConnection();
        addTables();
    }

    private void addTables() {
        try {

            connection.createStatement().execute("CREATE TABLE IF NOT EXISTS blocks(" +
                    "prevhash VARCHAR(64)," +
                    "signature VARCHAR(256)," +
                    "data TEXT," +
                    "name TEXT," +
                    "ts VARCHAR," +
                    "publickey TEXT" +
                    ");");

        } catch (SQLException ignored) {
        }
    }

    public void addBlockModel(BlockModel blockModel) {
        try {
            connection
                    .createStatement()
                    .execute("insert  into  blocks" +
                            "(prevhash,signature,data,name,ts,publickey) values " +
                            "('" + blockModel.getPrevhash() + "','" + blockModel.getSignature() + "'," +
                            "'" + blockModel.getData().getData() + "','" + blockModel.getData().getName() + "'," +
                            "'" + blockModel.getTs() + "','" + blockModel.getPublickey() + "') ON CONFLICT DO NOTHING ");
        } catch (SQLException ignored) {
        }
    }

    public void clean() {
        try {
            connection
                    .createStatement()
                    .execute("DELETE FROM blocks; ");
        } catch (SQLException ignored) {
        }
    }

}
