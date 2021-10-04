package com.company.view;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseInfo {
    String url;
    String username;
    String password;
    public DatabaseInfo() throws ClassNotFoundException {
        this.url = "jdbc:mysql://localhost:3306/farid_db";
        this.username = "root";
        this.password = "password";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getDatabaseBattleTableInfo() {
        ArrayList<String> battle_list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){

                    Statement statement = conn.createStatement();

                    ResultSet resultSet = statement.executeQuery("SELECT * FROM battle_info");
                    while(resultSet.next()){
                        int battle_id = resultSet.getInt(1);
                        String battle_mode = resultSet.getString(2);
                        String battle_log = resultSet.getString(3);
                        String submission_date = resultSet.getString(4);
                        battle_list.add(String.format("%d. %s - %s %s \n", battle_id, battle_mode, battle_log,submission_date));
                    }
                }
            catch(Exception ex){
                System.out.println("Connection failed...");

                System.out.println(ex);
            }
        return battle_list;
        }

    public void insertBattleInfoToDatabase(String battle_mode, String battle_log, String year_month_day){
        try (Connection conn = DriverManager.getConnection(this.url, this.username, this.password)){

            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT into battle_info(battle_mode, battle_log, submission_date) " +
                    "VALUES (\'"+battle_mode + "\',\'" + battle_log + "\',\'" + year_month_day + "\')");
            System.out.printf("Added %d rows", rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
