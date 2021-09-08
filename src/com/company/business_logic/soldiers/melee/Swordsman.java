package com.company.business_logic.soldiers.melee;

import com.company.business_logic.armor_composite.compositePattern.heavyArmor.LamellarArmorComposite;
import com.company.business_logic.shield.IronDecorator;
import com.company.business_logic.shield.LeatherDecorator;
import com.company.business_logic.shield.WoodenShield;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.weapon.baseWeapons.melee.Dagger;
import com.company.business_logic.weapon.baseWeapons.melee.Sword;

public class Swordsman extends BaseSoldier {

  public Swordsman(String name, SoldierPosition soldierPosition) {
    super(name, 100, new IronDecorator(new LeatherDecorator(new WoodenShield())),
        new LamellarArmorComposite(),"..\\..\\..\\view\\resources\\images\\Swordsman.JPG", soldierPosition);
    weaponArsenal.add(new Sword(50,50));
    weaponArsenal.add(new Dagger(10,10));
  }
}
