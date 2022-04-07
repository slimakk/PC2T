package PC2T;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DbSQL {
    private Connection conn;
    public boolean Connect()
    {
        conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:students.db");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void Disconnect()
    {
        if(conn != null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean CreateTable()
    {
        if(conn == null)
            return false;
        String studentsTable = "CREATE TABLE IF NOT EXISTS students("+"id integer PRIMARY KEY,"+"name varchar(255) NOT NULL," +
                ""+"surname varchar(255) NOT NULL,"+"birthday text NOT NULL,"+"type varchar(20) NOT NULL"+");";
        String gradeTable ="CREATE TABLE IF NOT EXISTS grades(id integer,grade integer,num integer,PRIMARY KEY (num), FOREIGN KEY (id) REFERENCES students (id) ON DELETE CASCADE ON UPDATE NO ACTION)";
        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute(studentsTable);
            stmt.execute(gradeTable);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void AddStudent(int ID, String name, String surname, int[] birthday, String type)
    {
        String sql = "INSERT OR IGNORE INTO students(id,name,surname,birthday,type)VALUES(?,?,?,?,?)";
        try
        {
            String date = birthday[2]+"-"+birthday[1]+"-"+birthday[0];
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,ID);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,surname);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5,type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddGrades(int ID, int grade, int i)
    {
        String sql = "INSERT OR IGNORE INTO grades(id,grade,num)VALUES(?,?,?)";
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,ID);
            preparedStatement.setInt(2,grade);
            preparedStatement.setInt(3,i);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
