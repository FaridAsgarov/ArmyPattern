package com.company.business_logic.shield;

import com.company.business_logic.armor_composite.materials.Leather;

public class LeatherDecorator extends Shield{
  private final WoodenShield woodenShield;

  public LeatherDecorator(WoodenShield woodenShield) {
    super(new Leather());
    this.woodenShield = woodenShield;
    this.shieldHP = woodenShield.shieldHP + this.material.getMaterialHP();
  }

  @Override
  public String toString() {
    return "This is " + material.getClass().getSimpleName() + "-coated " + woodenShield.material.getClass().getSimpleName() +"en shield which has " + shieldHP + "HP left";
  }

}
