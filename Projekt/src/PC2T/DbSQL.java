package PC2T;

import java.sql.*;

/**
 * Trieda obsahuje metody na pracu s SQL databazou
 */

public class DbSQL {
    private Connection conn;
    /**
     *Pripojenie k SQL databaze
     */
    public boolean Connect() {
        conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:students.db");
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    /**
     *Ukoncenie pripojenia k SQL databaze
     */
    public void Disconnect() throws SQLException {
        if(conn != null)
        {
            conn.close();
        }
    }
    /**
     *Vytvorenie tabuliek students a grades ak neexistuju
     * students - id, name, surname, birthday, type -> id je Primary key
     * grades - id, grade, num -> num je primary key, id je referencia na id v students
     */
    public boolean CreateTable() throws SQLException {
        if(conn == null)
            return false;
        String studentsTable = "CREATE TABLE IF NOT EXISTS students("+"id integer PRIMARY KEY,"+"name varchar(255) NOT NULL," +
                ""+"surname varchar(255) NOT NULL,"+"birthday text NOT NULL,"+"type varchar(20) NOT NULL"+");";
        String gradeTable ="CREATE TABLE IF NOT EXISTS grades(id integer,grade integer,num integer,PRIMARY KEY (num), FOREIGN KEY (id) REFERENCES students (id) ON DELETE CASCADE ON UPDATE NO ACTION)";
        Statement stmt = conn.createStatement();
        stmt.execute(studentsTable);
        stmt.execute(gradeTable);
        return true;
    }
    /**
     *Vlozenie noveho studenta do tabulky students
     */
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
            System.out.println(e.getMessage());
        }
    }
    /**
     *Vlozenie znamky do tabulky grades
     */
    public void AddGrades(int ID, int grade, int i)
    {
        String sql = "INSERT OR REPLACE INTO grades(id,grade,num)VALUES(?,?,?)";
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,ID);
            preparedStatement.setInt(2,grade);
            preparedStatement.setInt(3,i);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     *Nacitanie studentov z tabulky students naspat do TreeMap databazy
     */
    public  void LoadStudent(Databaza db)
    {
        String sql = "SELECT id, name, surname, birthday, type FROM students";
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                //SQLite uklada datum ako text vo formate yyyy-MM-dd -> rozdelenie do String[] a prevedenie do int[] vo formate dd.MM.yyyy
                String[] date = rs.getString("birthday").split("-");
                int[] datum = {Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0])};
                String type = rs.getString("type");
                db.setPrvkyDatabaze(id,name,surname,datum[0],datum[1],datum[2],type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *Nacitanie vsetkych znamok z grades do ArrayListu specifickeho ID
     */
    public void LoadGrades(int ID, Databaza db)
    {
        String sql = "SELECT grade FROM grades WHERE id=?";
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,ID);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                db.addZnamku(ID,rs.getInt("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *Vymaze studenta z tabulky students podla ID
     * Pouziva sa spolu s metodou DeleteGrades
     */
    public void DeleteStudent(int ID)
    {
        String sql = "DELETE FROM students WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *Vymaze vsetky znamky studenta z tabulky grades podla ID
     * Pouziva sa spolu s metodou DeleteStudent
     */
    public void DeleteGrades(int ID)
    {
        String sql = "DELETE FROM grades WHERE id=?";
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}