package rpg_lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> weaponInventory;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.weaponInventory = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            weaponInventory.add(target.getRandomWeapon());
        }
    }

    public List<Weapon> getInventory() {
        return Collections.unmodifiableList(weaponInventory);
    }

}
