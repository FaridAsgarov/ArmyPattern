package com.company.armor_factory.concreteArmorElements.fromCloth;
import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Cloth;

public class ClothLegGuard extends BaseArmor {

  public ClothLegGuard(){
    super(new Cloth());
  }
}
