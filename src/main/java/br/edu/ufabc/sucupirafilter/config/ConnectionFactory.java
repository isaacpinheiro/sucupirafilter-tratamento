package br.edu.ufabc.sucupirafilter.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection()
        throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/sucupirafilter";
        return DriverManager.getConnection(url, "sucupirafilter", "senha");

    }

}

