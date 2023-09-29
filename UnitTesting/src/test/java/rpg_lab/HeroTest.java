package rpg_lab;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class HeroTest {

    private static final String NAME = "Mike";
    private static final int EXPERIENCE = 10;

    @Test
    public void testAttackWhenTargetDiesAndGiveXpToHero() {

        Target facade = mock(Target.class);

        when(facade.isDead()).thenReturn(true);
        when(facade.giveExperience()).thenReturn(EXPERIENCE);

        Weapon mockedWeapon = mock(Weapon.class);

        Hero hero = new Hero(NAME, mockedWeapon);
        hero.attack(facade);

        assertEquals(EXPERIENCE, hero.getExperience());

    }

    @Test
    public void testAttackWhenRandomWeaponIsAddedToRepository() {

        Target facade = mock(Target.class);

        when(facade.isDead()).thenReturn(true);
        when(facade.giveExperience()).thenReturn(EXPERIENCE);

        Weapon mockedWeapon = mock(Weapon.class);

        Hero hero = new Hero(NAME, mockedWeapon);

        Weapon weapon = hero.getInventory().get(0);

        hero.attack(facade);

        assertEquals(EXPERIENCE, hero.getExperience());

    }

}
