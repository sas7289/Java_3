package Lesson_2;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {
        try {
            connection();
            Queries.connection();
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }


        try {
            createTable();
            truncateTable();
            floodTable();

            try {
                connection();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            try {
                Queries.getCoast("product1");
                Queries.setCoast("product1", 1111);
                Queries.getCoast("product1");
                Queries.getProducts(5000, 10000);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mainDB.db");
        stmt = connection.createStatement();
    }

    private static void createTable() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS products");
        stmt.executeUpdate("CREATE TABLE products (" +
                "good_id SERIAL PRIMARY KEY,\n" +
                "good_name VARCHAR(50) NOT NULL,\n" +
                "good_price INT);");
    }

    private static void truncateTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM products");
    }

    private static void floodTable() throws SQLException {
        for (int i = 0; i < 10000; i++) {

            stmt.addBatch(String.format("INSERT INTO products (good_name, good_price) " +
                    "values ('product%s', %d)", i, i*1111 + i*15/7));
        }
        connection.setAutoCommit(false);
        stmt.executeBatch();
        connection.setAutoCommit(true);
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }
}
