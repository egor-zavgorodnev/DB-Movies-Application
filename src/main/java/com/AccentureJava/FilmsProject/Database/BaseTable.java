package com.AccentureJava.FilmsProject.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTable {
    protected MoviesDB database = MoviesDB.getInstance();
    protected String tableName;

    protected BaseTable(String tableName) {
        this.tableName = tableName;
    }

    protected void execute(String sql) throws SQLException, ClassNotFoundException {
        database.openConnection();
        Statement statement = database.getStatement();
        statement.execute(sql);
        statement.close();
        database.closeConnection();
    };
    protected ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
        database.openConnection();
        Statement statement = database.getStatement();
        ResultSet rs = statement.executeQuery(sql);
        statement.close();
        database.closeConnection();
        return rs; 
    };
}