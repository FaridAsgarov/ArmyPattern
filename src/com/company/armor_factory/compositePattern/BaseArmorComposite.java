package com.company.armor_factory.compositePattern;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.Material;
import java.util.ArrayList;

public class BaseArmorComposite extends BaseArmor {

  public BaseArmorComposite(Material material) {
    super(material);
  }

   ArrayList<BaseArmor> ArmorEquipment = new ArrayList<BaseArmor>();

   protected void addArmorToList(BaseArmor baseArmor){
      ArmorEquipment.add(baseArmor);
   }

   public void removeArmorFromList(BaseArmor baseArmor){
     ArmorEquipment.remove(baseArmor);
   }

   public ArrayList<BaseArmor> getChildren(){
        return this.ArmorEquipment;
   }

   public int getTotalArmorHP(){
     int totalHP = 0;
     for (BaseArmor element : this.getChildren()) {
       totalHP += element.getArmorHP();
     }
     return totalHP;
   }
}
