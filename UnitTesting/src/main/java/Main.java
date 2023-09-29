import rpg_lab.*;

import java.util.List;

public class Main {

    public static final int ATTACK = 15;
    public static final int DURABILITY = 10;
    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 5;

    public static void main(String[] args) {

        Weapon axe = new Axe(ATTACK, DURABILITY);
        Weapon sword = new Sword(ATTACK, DURABILITY);

        Target dummy = new Dummy(HEALTH, EXPERIENCE, List.of(axe, sword));

        Hero hero = new Hero("Mike", axe);
        hero.attack(dummy);

        for (Weapon weapon : hero.getInventory()) {
            System.out.printf("Weapon type: %s%nAttack points: %d%nDurability points: %d%n", weapon.getClass().getSimpleName(), weapon.getAttackPoints(), weapon.getDurabilityPoints());
        }
    }

}
