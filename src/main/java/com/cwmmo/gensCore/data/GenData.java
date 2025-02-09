package com.cwmmo.gensCore.data;

import com.cwmmo.gensCore.GensCore;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class GenData {

    File dataFile = new File(GensCore.INSTANCE.getdataF()+"/data.db");
    String dbUrl = "jbdc:sqlite:"+dataFile.getPath();

    Connection conn;

    public Connection getConnection(){
        if (conn == null){
            try{
                conn = DriverManager.getConnection(dbUrl);
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public GenData(){
        if (!dataFile.exists()){
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            conn = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        if (conn == null){
            System.err.println("Connection is null");
            return;
        }

        try(Statement stmt = getConnection().createStatement()){
            String table = """
                        CREATE TABLE IF NOT EXISTS gens(
                            ID INTEGER PRIMARY AUTOINCREMENT,
                            player VARCHAR(100),
                            tier INT,
                            item VARBINARY(4096),
                            loc TEXT
                        )
                    """;
            stmt.execute(table);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
