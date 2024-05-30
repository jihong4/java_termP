package TermProject;

public class Item {
    private String name;
    private int attack;
    private int defense;

    public Item(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        if (attack > 0) {
            return name + " (공격력: " + attack + ")";
        } else {
            return name + " (방어력: " + defense + ")";
        }
    }
}
