package com.company.business_logic.armor_composite.compositePattern;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.Material;
import java.util.ArrayList;

public class BaseArmorComposite extends BaseArmor {

  public BaseArmorComposite(Material material) {
    super(material);
  }

  @Override
  public String toString() {
    String tmp = "";
    for (BaseArmor element : this.getChildren()) {
      tmp += element.toString() + "\n";
    }
    return tmp;
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
