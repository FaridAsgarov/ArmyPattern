package com.company.business_logic.armor_composite.compositePattern.heavyArmor;

import com.company.business_logic.armor_composite.Material;
import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;

public class HeavyArmorComposite extends BaseArmorComposite {

  public HeavyArmorComposite(Material material) {
    super(material);
    this.addArmorToList(new ChainMailArmorComposite());
    this.addArmorToList(new IronArmorComposite());
    this.addArmorToList(new LamellarArmorComposite());
    this.addArmorToList(new PlateArmorComposite());
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
