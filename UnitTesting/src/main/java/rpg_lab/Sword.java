package rpg_lab;

public class Sword implements Weapon {

    private int attackPoints;
    private int durabilityPoints;

    public Sword(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }

    @Override
    public int getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }

    @Override
    public void attack(Target target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("rpg_lab.Axe is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }

}
