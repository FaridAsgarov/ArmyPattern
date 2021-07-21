package com.company;

import com.company.armor_composite.compositePattern.heavyArmor.ChainmailArmorComposite;
import com.company.armor_composite.compositePattern.heavyArmor.HeavyArmorComposite;
import com.company.armor_composite.compositePattern.heavyArmor.IronArmorComposite;
import com.company.armor_composite.compositePattern.lightArmor.LightArmorComposite;
import com.company.shield.IronDecorator;
import com.company.shield.LeatherDecorator;
import com.company.shield.WoodenShield;
import com.company.soldiers.BaseSoldier;

public class Main {

    public static void main(String[] args) {

      BaseSoldier fred = new BaseSoldier("fred", 100,
         new IronDecorator(new LeatherDecorator(new WoodenShield())),
          null);

      BaseSoldier george = new BaseSoldier("george", 100,
          null,
          null);

      while(fred.isAlive() || george.isAlive()) {
          System.out.println(fred.attack(george));
          System.out.println(george.attack(fred));
      }
    }
}
