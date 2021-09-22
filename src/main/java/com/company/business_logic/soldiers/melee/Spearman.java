package com.company.business_logic.soldiers.melee;

import com.company.business_logic.armor_composite.compositePattern.lightArmor.LeatherArmorComposite;
import com.company.business_logic.shield.LeatherDecorator;
import com.company.business_logic.shield.WoodenShield;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.weapon.baseWeapons.melee.Dagger;
import com.company.business_logic.weapon.baseWeapons.melee.Spear;

public class Spearman extends BaseSoldier {

  public Spearman(String name, SoldierPosition soldierPosition) {
    super(name, 100, new LeatherDecorator(new WoodenShield()), new LeatherArmorComposite(), "..\\..\\..\\view\\resources\\images\\Spearman.JPG", soldierPosition);
    weaponArsenal.add(new Spear(50,25));
    weaponArsenal.add(new Dagger(10,10));
  }
}
