package com.company.iterator.concrete.collection;

import com.company.iterator.IterableCollection;
import com.company.iterator.Iterator;
import com.company.iterator.concrete.iterator.WeaponIterator;
import com.company.soldiers.factory.BaseWeapon;
import java.util.ArrayList;


public class WeaponCollection implements IterableCollection {
  WeaponIterator arsenalIndex;

  @Override
  public Iterator createIterator() {

  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object getNext() {
    return null;
  }

  @Override
  public void reset() {

  }
}
