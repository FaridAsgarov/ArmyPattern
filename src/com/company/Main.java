package com.company;

import com.company.soldiers.BaseSoldier;
import com.company.soldiers.ranged.Bowman;
import com.company.soldiers.ranged.Crossbowman;

public class Main {

    public static void main(String[] args) {

      BaseSoldier fred = new Bowman("fred");

      BaseSoldier george = new Crossbowman("george");

      while(fred.isAlive() && george.isAlive()) {
        System.out.println(fred.activeWeaponIndex);
        fred.attack(george);
          System.out.println("Fred attacks, George has HP left: " + george.totalHealthAndArmor);
//          george.attack(fred);
//          System.out.println("George attacks, Fred has HP left: " + fred.totalHealthAndArmor);
          fred.nextWeapon();
          System.out.println(fred.activeWeaponIndex);
      }
    }
}
