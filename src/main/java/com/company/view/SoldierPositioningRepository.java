package com.company.view;


import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.squad.Squad;

public class SoldierPositioningRepository {
  Squad squad;

  public SoldierPositioningRepository(Squad squad){
    this.squad = squad;
  }

  public Squad setPositions(int startDistanceX, int startDistanceY, int distance, int battlefieldHeight){
    for(BaseSoldier soldier: this.squad.getSoldierSquad()){
      soldier.setSoldierPosition(new SoldierPosition(startDistanceX, startDistanceY));

      if(startDistanceY + distance<battlefieldHeight){
        startDistanceY += distance;
      } else {
        startDistanceX += distance;
      }
    }
    return this.squad;
  }

}
