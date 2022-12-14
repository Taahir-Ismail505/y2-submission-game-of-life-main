package za.co.wethinkcode.game_of_life.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_work {
    private Connection connect() {
    String url = "jdbc:sqlite:Jeffs_Cake.db";
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return conn;
}
}
