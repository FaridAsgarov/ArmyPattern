package com.company.soldiers.melee;

import com.company.armor_composite.compositePattern.heavyArmor.LamellarArmorComposite;
import com.company.shield.IronDecorator;
import com.company.shield.LeatherDecorator;
import com.company.shield.WoodenShield;
import com.company.soldiers.BaseSoldier;
import com.company.weapon.baseWeapons.melee.Sword;

public class Swordsman extends BaseSoldier {

  public Swordsman(String name) {
    super(name, 100, new IronDecorator(new LeatherDecorator(new WoodenShield())),
        new LamellarArmorComposite());
    weaponArsenal.add(new Sword(50,50));
  }
}
