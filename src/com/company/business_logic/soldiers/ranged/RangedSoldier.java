package com.company.business_logic.soldiers.ranged;

import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.weapon.baseWeapons.ranged.RangedWeapon;

public class RangedSoldier extends BaseSoldier {

  public RangedSoldier(String name, int baseHP, BaseArmorComposite armorSet,
      String pathToImage, SoldierPosition soldierPosition) {
    super(name, baseHP, null, armorSet, pathToImage, soldierPosition);
  }

  public void reload(){
    if(weaponArsenal.get(activeWeaponIndex) instanceof RangedWeapon){
      ((RangedWeapon) weaponArsenal.get(activeWeaponIndex)).reload();
    }
  }

  @Override
  public int attack(BaseSoldier enemy) {
    reload();
    return super.attack(enemy);
  }
}
