package rpg_lab;

import static org.junit.Assert.*;
import static rpg_lab.AxeTest.ATTACK;
import static rpg_lab.AxeTest.DURABILITY;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DummyTest {

    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 5;
    private static final int ATTACK_POINTS = 5;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        Weapon axe = new Axe(ATTACK, DURABILITY);
        Weapon sword = new Sword(ATTACK, DURABILITY);

        dummy = new Dummy(HEALTH, EXPERIENCE, List.of(axe, sword));
        deadDummy = new Dummy(0, EXPERIENCE, List.of(axe, sword));
    }

    @Test
    public void testTakeAttackReducesHealth() {
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeAttackThrowsWhenDummyIsDead() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testGiveXpWhenDummyIsDead() {
        assertEquals(EXPERIENCE, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testGiveXpWhenDummyIsAlive() {
        assertEquals(EXPERIENCE, dummy.giveExperience());
    }

}
