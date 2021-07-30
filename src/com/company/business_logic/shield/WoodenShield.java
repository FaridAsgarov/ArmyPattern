package com.company.business_logic.shield;

import com.company.business_logic.armor_composite.materials.Wood;

public class WoodenShield extends Shield {

  public WoodenShield() {
    super(new Wood());
  }
}
