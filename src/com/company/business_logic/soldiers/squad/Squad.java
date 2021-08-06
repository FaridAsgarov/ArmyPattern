package com.company.business_logic.soldiers.squad;

import com.company.business_logic.soldiers.BaseSoldier;
import java.util.ArrayList;

public class Squad {
   ArrayList<BaseSoldier> soldierSquad = new ArrayList<>();
   public String squadName;

   public Squad(String squadName){
     this.squadName = squadName;
   }

   public void addSoldierToTheSquad(BaseSoldier soldier){
     soldierSquad.add(soldier);
   }

   public void removeSoldierFromTheSquad(BaseSoldier soldier){
     soldierSquad.remove(soldier);
   }

   public int squadAttackEnemySoldier(BaseSoldier enemy){
     int damageSum = 0;
     for(BaseSoldier soldier: soldierSquad){
       if(soldier.isAlive()) {
         damageSum += soldier.attack(enemy);
       }
     }
     return damageSum;
   }

   public int squadAttackEnemySquad(Squad enemySquad){
     int damageSum = 0;

     for(BaseSoldier soldier: soldierSquad){
       for(BaseSoldier enemy: enemySquad.getSoldierSquad())
           if(soldier.isAlive()) {
             damageSum += soldier.attack(enemy);
           }
     }

     return damageSum;
   }

  public ArrayList<BaseSoldier> getSoldierSquad() {
    return soldierSquad;
  }

  public boolean isAlive(){
     boolean isAlive = true;
     if(this.getTotalHP()<=0){
       isAlive = false;
     };
     return isAlive;
  }

  public int getTotalHP() {
    int totalHP = 0;
    for (BaseSoldier soldier: soldierSquad){
      totalHP += soldier.getTotalHealthAndArmor();
    }
    return totalHP;
  }

  public String getName(){
    return this.squadName;
  }

  public void setSquadName(String squadName) {
    this.squadName = squadName;
  }
}
