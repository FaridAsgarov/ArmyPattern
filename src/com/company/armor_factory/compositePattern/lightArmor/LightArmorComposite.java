package com.company.armor_factory.compositePattern.lightArmor;

import com.company.armor_factory.Material;
import com.company.armor_factory.compositePattern.BaseArmorComposite;

public class LightArmorComposite extends BaseArmorComposite {

  public LightArmorComposite(Material material) {
     super(material);
     this.addArmorToList(new ClothArmorComposite());
     this.addArmorToList(new LeatherArmorComposite());
  }



}
