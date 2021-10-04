package com.company;
import com.company.view.DatabaseInfo;


public class Main{

  public static void main(String[] args) throws ClassNotFoundException {
    DatabaseInfo battle_info = new DatabaseInfo();
    battle_info.getDatabaseBattleTableInfo().forEach(System.out::println);


  }
}