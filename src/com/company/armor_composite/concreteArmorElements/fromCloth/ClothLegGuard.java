package com.company.armor_composite.concreteArmorElements.fromCloth;
import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Cloth;

public class ClothLegGuard extends BaseArmor {

  public ClothLegGuard(){
    super(new Cloth());
  }
}
