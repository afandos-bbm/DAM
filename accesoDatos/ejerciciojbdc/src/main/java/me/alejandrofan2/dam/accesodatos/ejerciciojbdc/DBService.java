package me.alejandrofan2.dam.accesodatos.ejerciciojbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    private String url;
    private String user;
    private String password;
    private Connection connection;

    public DBService(String url) {
        super();
        this.url = url;
        user = "postgres";
        password = "postgres";
    }

    public DBService(String url, String user, String password) {
        super();
        this.url = url;
        this.user = user;
        this.password = password;
    }

    
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
    
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    
    public String getUrl() {
        return url;
    }
}
