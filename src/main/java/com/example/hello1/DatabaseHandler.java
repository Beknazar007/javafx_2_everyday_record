package com.example.hello1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler extends Configs {
    final static String connectionString = "jdbc:postgresql://"+dbHost+":"+dbPort+"/"+dbName ;
    static Connection dbConnection = null;
    final static String SELECT_QUERY =
            "SELECT * FROM students";



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

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE "
                + Const.USERS_LOGIN + " = ? AND " + Const.USERS_PASS + " = ?";

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
    public static List<Tasks> init() {
        Statement statement = null;
        List<Tasks> tasks = new ArrayList<>();
        try {
            if (dbConnection == null) {
                dbConnection = DriverManager.getConnection(connectionString, Configs.dbUser, Configs.dbPass);
            }
            statement = dbConnection.createStatement();
            ResultSet res = statement.executeQuery(SELECT_QUERY);
            while (res.next()) {
                Tasks task = new Tasks();
                task.setTaskId(Integer.toString(res.getInt("taskId")));
                task.setTask(res.getString("task"));
                task.setTaskDate(res.getString("taskDate"));
                tasks.add(task);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tasks;
    }
    public static void addTask(Tasks task) {
        try {
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate("INSERT INTO "+ Const.TASK_TABLE + "(" + Const.TASK_NAME + "," +
                    Const.TASK_DATE +") " + "VALUES ('" + task.getTask() +"','" + task.getTaskDate() + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteTask(int id){
        try {
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate("DELETE FROM " + Const.TASK_TABLE + " WHERE " + Const.TASK_ID + "=" + Integer.toString(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
