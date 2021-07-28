package com.company.shield;

import com.company.armor_composite.materials.Iron;

public class IronDecorator extends Shield{
  private LeatherDecorator leatherDecorator;

  public IronDecorator(LeatherDecorator leatherDecorator) {
    super(new Iron());
    this.leatherDecorator = leatherDecorator;
    this.shieldHP = leatherDecorator.shieldHP + this.material.getMaterialHP();
  }

  @Override
  public String toString() {
    return "This is " + material.getClass().getSimpleName() + "-coated " + leatherDecorator.material.getClass().getSimpleName()
        +" decorated Wooden shield which has " + shieldHP + "HP left";
  }
}
