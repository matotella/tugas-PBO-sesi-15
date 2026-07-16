package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/db_kas";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Koneksi database berhasil.");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver JDBC tidak ditemukan!");

        } catch (SQLException e) {

            System.out.println("Koneksi database gagal!");
            System.out.println(e.getMessage());

        }

        return conn;

    }

}