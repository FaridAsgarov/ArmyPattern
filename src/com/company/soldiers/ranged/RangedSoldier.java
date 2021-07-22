package com.company.soldiers.ranged;

import com.company.armor_composite.compositePattern.BaseArmorComposite;
import com.company.soldiers.BaseSoldier;
import com.company.weapon.baseWeapons.ranged.RangedWeapon;

public class RangedSoldier extends BaseSoldier {

  public RangedSoldier(String name, int baseHP,
      BaseArmorComposite armorSet) {
    super(name, baseHP, null, armorSet);
  }

  public void reload(){
    if(weaponArsenal.get(0) instanceof RangedWeapon){
      ((RangedWeapon) weaponArsenal.get(0)).reload();
    }
  }

  @Override
  public int attack(BaseSoldier enemy) {
    reload();
    return super.attack(enemy);
  }
}
