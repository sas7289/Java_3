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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            disconnect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void disconnect() throws SQLException {
        stmt.close();
    }

    private static void getCoast(String nameProduct) throws SQLException {
        rs = stmt.executeQuery(String.format("SELECT good_price FROM products WHERE good_name = '%s'", nameProduct));
/*        rs.next();
        if(rs.next()) {*/
//        boolean temp = rs.next();
//            int coast = rs.getInt("good_price");
        String result = rs.next() ? String.valueOf(rs.getInt("good_price")) : "Такого товара нет";
        System.out.printf(result);
/*        }
        int coast = rs.getInt("good_price");
        System.out.printf(coast == 0 ? "Такого товара нет" : "%d", coast);*/
    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mainDB.db");
        stmt = connection.createStatement();
    }
}
