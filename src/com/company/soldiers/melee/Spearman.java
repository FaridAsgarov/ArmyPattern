package com.company.soldiers.melee;

import com.company.armor_composite.compositePattern.BaseArmorComposite;
import com.company.armor_composite.compositePattern.lightArmor.LeatherArmorComposite;
import com.company.shield.LeatherDecorator;
import com.company.shield.Shield;
import com.company.shield.WoodenShield;
import com.company.soldiers.BaseSoldier;
import com.company.weapon.baseWeapons.melee.Spear;

public class Spearman extends BaseSoldier {

  public Spearman(String name) {
    super(name, 100, new LeatherDecorator(new WoodenShield()), new LeatherArmorComposite());
    weaponArsenal.add(new Spear(50,25));
  }
}
