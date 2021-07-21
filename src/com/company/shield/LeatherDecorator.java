package com.company.shield;

import com.company.armor_composite.materials.Leather;

public class LeatherDecorator extends Shield{
  private WoodenShield woodenShield;

  public LeatherDecorator(WoodenShield woodenShield) {
    super(new Leather());
    this.woodenShield = woodenShield;
    this.shieldHP = woodenShield.shieldHP + this.material.getMaterialHP();
  }

  @Override
  public String toString() {
    return "This is " + material.getClass().getName() + "-coated " + woodenShield.material.getClass().getName() +"en shield which has " + shieldHP + "HP left";
  }

}
