package com.company;

import com.company.business_logic.soldiers.melee.Spearman;
import com.company.business_logic.soldiers.melee.Swordsman;
import com.company.business_logic.soldiers.ranged.Bowman;
import com.company.business_logic.soldiers.ranged.Crossbowman;
import com.company.business_logic.soldiers.squad.Squad;
import com.company.view.MainGUIwindow;

public class Main {

    public static void main(String[] args) {

//      new MainGUIwindow();

        Squad AustrianSquad = new Squad("Austrian");
        AustrianSquad.addSoldierToTheSquad(new Bowman("A"));
        AustrianSquad.addSoldierToTheSquad(new Crossbowman("B"));
        AustrianSquad.addSoldierToTheSquad(new Spearman("C"));
        AustrianSquad.addSoldierToTheSquad(new Swordsman("D"));

        Squad FrenchSquad = new Squad("French");
        FrenchSquad.addSoldierToTheSquad(new Bowman("A"));
        FrenchSquad.addSoldierToTheSquad(new Crossbowman("B"));
        FrenchSquad.addSoldierToTheSquad(new Spearman("C"));
        FrenchSquad.addSoldierToTheSquad(new Swordsman("D"));

        while(AustrianSquad.isAlive() && FrenchSquad.isAlive()){
            AustrianSquad.squadAttackEnemySquad(FrenchSquad);
            System.out.println("Austrian Squad attacked French Squad, French Squad has total HP left: " + FrenchSquad.getTotalHP());

            if(AustrianSquad.isAlive() && !FrenchSquad.isAlive())
            {
                System.out.println("Austrian Squad Wins!");
                break;
            }
            if(!AustrianSquad.isAlive() && FrenchSquad.isAlive())
            {
                System.out.println("French Squad Wins!");
                break;
            }

            FrenchSquad.squadAttackEnemySquad(AustrianSquad);
            System.out.println("French Squad attacked Austrian Squad, Austrian Squad has total HP left: " + FrenchSquad.getTotalHP());

            if(AustrianSquad.isAlive() && !FrenchSquad.isAlive())
            {
                System.out.println("Austrian Squad Wins!");
                break;
            }
            if(!AustrianSquad.isAlive() && FrenchSquad.isAlive())
            {
                System.out.println("French Squad Wins!");
                break;
            }
        }
    }
}

