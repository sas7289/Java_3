package Lesson_2;

import java.sql.*;

public class Queries {
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String[] args) {
        try {
            connection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {
            getCoast("product1");
            setCoast("product1", 1111);
            getCoast("product1");
            getProducts(5000, 10000);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            disconnect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void getProducts(int begin, int end) throws SQLException {
        rs = stmt.executeQuery(String.format("SELECT * FROM products WHERE good_price BETWEEN %d AND %d", begin, end));
        while (rs.next()) {
            System.out.printf("%s %d%n", rs.getString("good_name"), rs.getInt("good_price"));
        }
    }

    private static void setCoast(String nameProduct, int coast) throws SQLException {
        stmt.executeUpdate(String.format("UPDATE products SET good_price = %d WHERE good_name = '%s'", coast, nameProduct));
    }

    private static void disconnect() throws SQLException {
        stmt.close();
    }

    private static void getCoast(String nameProduct) throws SQLException {
        rs = stmt.executeQuery(String.format("SELECT good_price FROM products WHERE good_name = '%s'", nameProduct));

        String result = rs.next() ? String.valueOf(rs.getInt("good_price") + "\n") : "Такого товара нет\n";
        System.out.printf(result);

    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mainDB.db");
        stmt = connection.createStatement();
    }
}
