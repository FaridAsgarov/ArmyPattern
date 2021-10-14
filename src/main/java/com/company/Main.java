package com.company;


import com.company.view.DatabaseInfo;
import com.company.view.MainMenu;

public class Main{

  public static void main(String[] args) throws ClassNotFoundException {
//    DatabaseInfo battle_info = new DatabaseInfo();
//    battle_info.getDatabaseBattleTableInfo().forEach(System.out::println);
//  battle_info.insertBattleInfoToDatabase("Squad vs Squad AutoBattle","Peter won!", "2021-10-03");
          new MainMenu();

  }
}