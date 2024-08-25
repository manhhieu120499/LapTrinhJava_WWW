package iuh.fit.session01.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private final String url = "jdbc:mariadb://localhost:3306/session1";
    private final String username = "root";
    private final String password = "";
    private Connection con = null;

    public ConnectDB() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return con;
    }


}
