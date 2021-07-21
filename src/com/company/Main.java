package com.company;

import com.company.armor_composite.compositePattern.heavyArmor.ChainmailArmorComposite;
import com.company.armor_composite.compositePattern.heavyArmor.HeavyArmorComposite;
import com.company.armor_composite.compositePattern.heavyArmor.IronArmorComposite;
import com.company.armor_composite.compositePattern.lightArmor.LightArmorComposite;
import com.company.shield.IronDecorator;
import com.company.shield.LeatherDecorator;
import com.company.shield.WoodenShield;
import com.company.soldiers.BaseSoldier;
import com.company.soldiers.melee.Spearman;

public class Main {

    public static void main(String[] args) {

      BaseSoldier fred = new Spearman("fred");

      BaseSoldier george = new Spearman("george");

      while(fred.isAlive() && george.isAlive()) {
          System.out.println(fred.attack(george));
          System.out.println("George has HP left: " + george.totalHealthAndArmor);
          System.out.println(george.attack(fred));
          System.out.println("Fred has HP left: " + fred.totalHealthAndArmor);
      }
    }
}
