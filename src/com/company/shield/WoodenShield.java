package com.company.shield;

import com.company.armor_factory.Material;
import com.company.armor_factory.materials.Wood;

public class WoodenShield extends Shield {

  public WoodenShield() {
    super(new Wood());
  }
}
