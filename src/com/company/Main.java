package com.company;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.compositePattern.heavyArmor.ChainmailArmorComposite;
import com.company.armor_factory.compositePattern.heavyArmor.HeavyArmorComposite;
import com.company.armor_factory.compositePattern.heavyArmor.IronArmorComposite;
import com.company.armor_factory.compositePattern.heavyArmor.LamellarArmorComposite;
import com.company.armor_factory.compositePattern.heavyArmor.PlateArmorComposite;
import com.company.armor_factory.compositePattern.lightArmor.ClothArmorComposite;
import com.company.armor_factory.compositePattern.lightArmor.LeatherArmorComposite;
import com.company.armor_factory.compositePattern.lightArmor.LightArmorComposite;
import com.company.armor_factory.materials.Chainmail;
import com.company.armor_factory.materials.Cloth;
import com.company.armor_factory.materials.Leather;
import com.company.shield.IronDecorator;
import com.company.shield.LeatherDecorator;
import com.company.shield.Shield;
import com.company.shield.WoodenShield;

public class Main {

    public static void main(String[] args) {
//        ClothArmorComposite clothArmorSet = new ClothArmorComposite();
//        System.out.println(clothArmorSet.toString());
//        for(BaseArmor baseArmor : clothArmorSet.getChildren()) {
//            System.out.println(baseArmor.toString());
//        }
//         System.out.println(clothArmorSet.getTotalArmorHP());
//        LeatherArmorComposite leatherArmorSet = new LeatherArmorComposite();
//        System.out.println(leatherArmorSet.getTotalArmorHP());

//        ChainmailArmorComposite chainmailArmorSet = new ChainmailArmorComposite();
//         System.out.println(chainmailArmorSet.getTotalArmorHP());
//
//        IronArmorComposite ironArmorSet = new IronArmorComposite();
//        System.out.println(ironArmorSet.getTotalArmorHP());
//
//        LamellarArmorComposite lamellarArmorSet = new LamellarArmorComposite();
//        System.out.println(lamellarArmorSet.getTotalArmorHP());
//
//        PlateArmorComposite plateArmorSet = new PlateArmorComposite();
//        System.out.println(plateArmorSet.getTotalArmorHP());

//        LightArmorComposite lightArmorSet = new LightArmorComposite(null);
//////        System.out.println(lightArmorSet.toString());
//////        System.out.println(lightArmorSet.getChildren().size());
////          System.out.println(lightArmorSet.getTotalArmorHP());
////
////        HeavyArmorComposite heavyArmorSet = new HeavyArmorComposite(null);
////        System.out.println(heavyArmorSet.getTotalArmorHP());

        Shield ironShield = new IronDecorator(new LeatherDecorator(new WoodenShield()));
        System.out.println(ironShield.toString());

    }
}
