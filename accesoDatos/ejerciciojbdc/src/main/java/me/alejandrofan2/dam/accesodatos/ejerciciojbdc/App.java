package me.alejandrofan2.dam.accesodatos.ejerciciojbdc;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    private static final String ADDR = "jdbc:postgresql://tyke.db.elephantsql.com/dhbufbue";
    private static final String USER = "dhbufbue";
    private static final String PWD = "sUOUX1SjEBcsPYphPThsVqhkOUifJfVk";
    private static DBService dbService;
    public static void main(String[] args) {
        run();
        closeConnection();
    }

    public static Connection init() {
        dbService = new DBService(ADDR, USER, PWD);
        try {
            return dbService.getConnection();
        } catch (SQLException e) {
            out.println(
                    "\nApp.main() - Error al conectar con la base de datos - dbService.getConnection()");
                    System.err.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }

    public static void run() {
        Connection connection = init();
        try {
            Statement statement = connection.createStatement();
            statement.execute(SQLQueries.CREACION.getSql());
        } catch (SQLException e) {
            out.println(
                    "\nApp.main() - Error al ejecutar la consulta - connection.createStatement().execute()");
        } catch (NullPointerException e) {
            out.println(
                    "\nApp.main() - Error al conectar con la base de datos - connection.createStatement().execute()");
            System.exit(1);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                out.println(
                        "\nApp.main() - Error al cerrar la conexión con la base de datos - connection.close()");
                System.exit(1);
            }
        }
    }

    public static void closeConnection() {
        try {
            dbService.closeConnection();
        } catch (SQLException e) {
            out.println(
                    "\nApp.main() - Error al cerrar la conexión con la base de datos - dbService.closeConnection()");
            System.exit(1);
        }
    }
}
