package com.company.armor_factory.compositePattern.lightArmor;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.Material;
import com.company.armor_factory.compositePattern.BaseArmorComposite;

public class LightArmorComposite extends BaseArmorComposite {

  public LightArmorComposite(Material material) {
     super(material);
     this.addArmorToList(new ClothArmorComposite());
     this.addArmorToList(new LeatherArmorComposite());
  }

  @Override
  public int getTotalArmorHP() {
    int totalHP = 0;
    for (var element : this.getChildren())
    {
      for(var t : ((BaseArmorComposite)element).getChildren()) {
       totalHP += t.getArmorHP();
      }
    }
    return totalHP;
  }
}

