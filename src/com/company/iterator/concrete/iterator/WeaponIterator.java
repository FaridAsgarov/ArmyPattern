package com.company.iterator.concrete.iterator;

import com.company.iterator.Iterator;
import com.company.soldiers.factory.BaseWeapon;
import com.company.soldiers.factory.Weapon;
import java.util.ArrayList;
import java.util.Collection;

public class WeaponIterator implements Iterator {
  private ArrayList<BaseWeapon> Arsenal= new ArrayList<BaseWeapon>();
  private int currentPosition = 0;

  public WeaponIterator(ArrayList<BaseWeapon> arsenal){
      this.Arsenal = arsenal;
  }


  @Override
  public boolean hasNext() {
    return currentPosition < this.Arsenal.toArray().length;
  }

  @Override
  public Object getNext() {
    if(!hasNext()){
      return null;
    }
    BaseWeapon currentAr = Arsenal.get(currentPosition);
    if(getNext()==null){
        reset();
    }
    currentPosition++;
    return currentAr;
  }

  @Override
  public void reset() {
      currentPosition = 0;
  }
}
