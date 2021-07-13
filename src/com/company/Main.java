package com.company;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.compositePattern.lightArmor.ClothArmorComposite;

public class Main {

    public static void main(String[] args) {
        ClothArmorComposite clothArmorSet = new ClothArmorComposite();
//        System.out.println(clothArmorSet.toString());
//        for(BaseArmor baseArmor : clothArmorSet.getChildren()) {
//            System.out.println(baseArmor.toString());
//        }
//         System.out.println(clothArmorSet.getTotalArmorHP());
    }
}
