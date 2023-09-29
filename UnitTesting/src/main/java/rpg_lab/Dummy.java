package rpg_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dummy implements Target {

    private int health;
    private int experience;

    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience, List<Weapon> weapons) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = weapons;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("rpg_lab.Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon getRandomWeapon() {
        int rndIndex = ThreadLocalRandom.current().nextInt(0, 2);

        return possibleLoot.get(rndIndex);
    }

}
