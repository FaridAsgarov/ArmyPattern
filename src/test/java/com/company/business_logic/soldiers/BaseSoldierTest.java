package com.company.business_logic.soldiers;

import com.company.business_logic.soldiers.ranged.Bowman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseSoldierTest {
    @Test
    public void isAliveTest() {
        BaseSoldier bob = new Bowman("Bob", new SoldierPosition(0, 0));
        assertTrue(bob.isAlive());
}

}