package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AxeTest {

    public static final int ATTACK = 15;
    public static final int DURABILITY = 10;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 5;

    private Weapon axe;
    private Weapon sword;
    private Weapon brokenAxe;
    private Dummy dummy;

    /**
     * Arrange Data
     */
    @Before
    public void setUp() {
        axe = new Axe(ATTACK, DURABILITY);
        sword = new Sword(ATTACK, DURABILITY);
        brokenAxe = new Axe(ATTACK, 0);
        dummy = new Dummy(HEALTH, EXPERIENCE, List.of(axe, sword));
    }

    @Test
    public void testAttackReducesDurability() {
        //Act
        axe.attack(dummy);

        //Assert
        int expectedDurability = DURABILITY - 1;
        Assert.assertEquals(expectedDurability, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackThrowsWithBrokenWeapon() {
        brokenAxe.attack(dummy);
    }

}
