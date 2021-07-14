package com.company.armor_factory.compositePattern.heavyArmor;

import com.company.armor_factory.Material;
import com.company.armor_factory.compositePattern.BaseArmorComposite;

public class HeavyArmorComposite extends BaseArmorComposite {

  public HeavyArmorComposite(Material material) {
    super(material);
    this.addArmorToList(new ChainmailArmorComposite());
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
