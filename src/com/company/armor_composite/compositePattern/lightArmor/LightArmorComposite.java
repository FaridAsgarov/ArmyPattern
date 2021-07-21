package com.company.armor_composite.compositePattern.lightArmor;

import com.company.armor_composite.Material;
import com.company.armor_composite.compositePattern.BaseArmorComposite;

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

