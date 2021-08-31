package com.company.business_logic.soldiers;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;
import com.company.business_logic.armor_composite.compositePattern.lightArmor.ClothArmorComposite;
import com.company.business_logic.armor_composite.compositePattern.lightArmor.LeatherArmorComposite;
import com.company.business_logic.shield.Shield;
import com.company.business_logic.weapon.Weapon;
import com.company.business_logic.weapon.baseWeapons.ranged.RangedWeapon;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;



public class BaseSoldier implements Movable{
  protected String name;
  protected int baseHP;
  public int totalHealthAndArmor;
  protected BaseArmorComposite armorSet;
  protected Shield shield;
  protected ArrayList<Weapon> weaponArsenal = new ArrayList<>();
  public int activeWeaponIndex = 0;
  private ImageIcon soldierImage;
  private int imageWidth = 100;
  private int imageHeight = 100;
  SoldierPosition soldierPosition;

  public BaseSoldier(String name, int baseHP, Shield shield, BaseArmorComposite armorSet, String pathToImage, SoldierPosition soldierPosition)
  {
      this.name = name;
      this.baseHP = baseHP;
      this.armorSet = armorSet;
      this.totalHealthAndArmor = baseHP + armorSet.getTotalArmorHP();
      this.shield = shield;
      this.soldierImage = new ImageIcon(new ImageIcon(getClass().getResource(pathToImage)).getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT));
      this.soldierPosition = soldierPosition;
  }


  public int attack(BaseSoldier enemy) {
    int attack = 0;
    int block = 0;

    if(enemy.isAlive()){
      if(getInitiative()>50) {
        attack = weaponArsenal.get(activeWeaponIndex).attack();
        if(enemy.getInitiative()>50) {
          block = enemy.defend();
        }
        int dmg = attack - block;

        if (dmg > 0) {
          enemy.totalHealthAndArmor -= dmg;
          return weaponArsenal.get(activeWeaponIndex).attack();
        }
      }
    }
    return 0;
  }

  public int shieldRam(BaseSoldier enemy){
    int attack = 0;
    int block = 0;

    if(shield!=null){
      if(enemy.isAlive()){
        if(getInitiative()>50) {
       attack = shield.ramWithShield();
          if(enemy.getInitiative()>50) {
            block = enemy.defend();
          }
       int dmg = attack - block;

       if(dmg>0) {
         enemy.totalHealthAndArmor -= dmg;
         return shield.ramWithShield();
       }
       }
      }
    }
    return 0;
  }

  public int defend() {
    if(weaponArsenal.get(activeWeaponIndex) instanceof RangedWeapon){
      return 0;
    }
    if(shield==null) {
      return weaponArsenal.get(activeWeaponIndex).defend();
    }
    return shield.defendWithShield();
  }


  public boolean isAlive() {
    return this.totalHealthAndArmor > 0;
  }

  public int nextWeapon(){
    if(activeWeaponIndex+1 >= weaponArsenal.size()) {
      return activeWeaponIndex=0;
    }
    return ++activeWeaponIndex;
  }

  public int previousWeapon(){
    if(activeWeaponIndex-1 < 0) {
      return activeWeaponIndex = weaponArsenal.size() - 1;
    }
    return --activeWeaponIndex;
  }

  public int getLightArmorBonusToInitiative(){
    int armorBonusToinitiative = 0;
    for (BaseArmor element : armorSet.getChildren()) {
      if(element instanceof LeatherArmorComposite || element instanceof ClothArmorComposite) {
        armorBonusToinitiative += 5;
      }
    }
    return armorBonusToinitiative;
  }

  public double calcDefaultInitiative(){
    return Math.random() * 100;
  }

  public double getInitiative() {
    return calcDefaultInitiative() + getLightArmorBonusToInitiative();
  }

  public int getTotalHealthAndArmor(){
    return this.totalHealthAndArmor;
  }

  public String getName(){
    return this.name;
  }

  public void setImageHeight(int imageHeight) {
    this.imageHeight = imageHeight;
  }

  public void setImageWidth(int imageWidth) {
    this.imageWidth = imageWidth;
  }

  public ImageIcon getSoldierImage() {
    return soldierImage;
  }

  @Override
  public void moveUp() {
    soldierPosition.positionY -= imageHeight;
  }

  @Override
  public void moveDown() {
    soldierPosition.positionY += imageHeight;
  }

  @Override
  public void moveLeft() {
    soldierPosition.positionX -= imageWidth;
  }

  @Override
  public void moveRight() {
    soldierPosition.positionX += imageWidth;
  }

  @Override
  public void moveUpAndLeft() {
    soldierPosition.positionY -= imageHeight;
    soldierPosition.positionX -= imageWidth;
  }

  @Override
  public void moveUpAndRight() {
    soldierPosition.positionY -= imageHeight;
    soldierPosition.positionX += imageWidth;
  }

  @Override
  public void moveDownAndLeft() {
    soldierPosition.positionY += imageHeight;
    soldierPosition.positionX -= imageWidth;
  }

  @Override
  public void moveDownAndRight() {
    soldierPosition.positionY += imageHeight;
    soldierPosition.positionX += imageWidth;
  }

  public SoldierPosition getSoldierPosition() {
    return soldierPosition;
  }

  public void checkBoundaries(int minX, int maxX, int minY, int maxY){
    if(soldierPosition.positionX < minX){
      soldierPosition.positionX = minX;
    }
    if(soldierPosition.positionX > maxX){
      soldierPosition.positionX = maxX;
    }
    if(soldierPosition.positionY < minY){
      soldierPosition.positionY = minY;
    }
    if(soldierPosition.positionY > maxY){
      soldierPosition.positionY = maxY;
    }
  }

}
