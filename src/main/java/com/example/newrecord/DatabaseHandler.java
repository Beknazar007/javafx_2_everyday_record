package com.example.newrecord;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler extends DatabaseModule {
    final static String connectionString = "jdbc:postgresql://"+dbHost+":"+dbPort+"/"+dbName ;
    static Connection dbConnection = null;


    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("Connected to Postgres");
        return dbConnection;
    }
    public static Connection getConnection() throws  SQLException {
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("Connected to Postgres");
        return dbConnection;
    }
    public  void addNewUser(SignUp_Module_Class user){

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

    public  void addNewUserWishes(Wishes_Module_class userTime){

        String query1 = "INSERT INTO wish(name ,surname , wishes ,recdate ) VALUES(?,?,?,?::date)";

        try (
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query1)) {

            preparedStatement.setString(1, userTime.getName());
            preparedStatement.setString(2, userTime.getSurname());
            preparedStatement.setString(3, userTime.getWishes());
            preparedStatement.setString(4, userTime.getDate());
            System.out.println(userTime.getName());
            System.out.println(userTime.getSurname());
            System.out.println(userTime.getWishes());
            System.out.println(String.valueOf(userTime.getDate()));
            preparedStatement.executeUpdate();
            System.out.println("Success is Waiting for you)");

        }catch (SQLException | ClassNotFoundException e){
            Logger lgr = Logger.getLogger(DatabaseHandler.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(),e);
        }
    }
    public ResultSet getUser(SignUp_Module_Class user){
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





}
