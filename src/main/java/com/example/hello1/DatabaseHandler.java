package com.example.hello1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler extends DatabaseModule {
    final static String connectionString = "jdbc:postgresql://"+dbHost+":"+dbPort+"/"+dbName ;
    static Connection dbConnection = null;
    final static String SELECT_QUERY =
            "SELECT userId , coming, leaving, studying, recDate FROM users_time ";



    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public  void addNewUser(User user){

        String query = "INSERT INTO students(last_name ,name , login , password) VALUES(?,?,?,?)";

        try (
            PreparedStatement pst = getDbConnection().prepareStatement(query)) {

            pst.setString(1, user.getLastName());
            pst.setString(2, user.getFirstName());
            pst.setString(3, user.getUserName());
            pst.setString(4, user.getPassword());
            pst.executeUpdate();
            System.out.println("Successfully created");

        }catch (SQLException | ClassNotFoundException e){
            Logger lgr = Logger.getLogger(DatabaseHandler.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(),e);
        }
    }

    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Table_Info_Module.USER_TABLE + " WHERE "
                + Table_Info_Module.USERS_LOGIN + " = ? AND " + Table_Info_Module.USERS_PASS + " = ?";

        try {
            PreparedStatement pst = getDbConnection().prepareStatement(select);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());

            resSet = pst.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public static List<User_time> init() {
        Statement statement = null;
        List<User_time> user_times = new ArrayList<>();
        try {
            if (dbConnection == null) {
                dbConnection = DriverManager.getConnection(connectionString, DatabaseModule.dbUser, DatabaseModule.dbPass);
            }
            statement = dbConnection.createStatement();
            ResultSet res = statement.executeQuery(SELECT_QUERY);
            while (res.next()) {
                User_time user_time = new User_time();
                user_time.setUserId(Integer.toString(res.getInt("userId")));
                user_time.setComing(res.getString("comming"));
                user_time.setLeaving(res.getString("leaving"));
                user_time.setStudying(res.getString("studying"));
                user_time.setRecDate(res.getString("recDate"));
                user_times.add(user_time);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user_times;
    }
    public static void addNewTime(User_time userTime) {
        try {
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate("INSERT INTO "+ Table_Info_Module.TASK_TABLE + "(" + Table_Info_Module.TASK_COMM + "," +
                    Table_Info_Module.TASK_LEAV +","+ Table_Info_Module.TASK_STUD+","+ Table_Info_Module.TASK_DATE+") " + "VALUES ('"  + userTime.getComing() +"','" + userTime.getLeaving() +"','" + userTime.getStudying() +"','" + userTime.getRecDate() + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteTask(int id){
        try {
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate("DELETE FROM " + Table_Info_Module.TASK_TABLE + " WHERE " + Table_Info_Module.TASK_ID + "=" + Integer.toString(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
