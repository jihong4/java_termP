public class Monster_Status extends OIS_Status {
    private String name;
    private int gold;
    private int exp;

    public Monster_Status(String name, int hp, int atk, int def, int mana, int gold, int exp) {
        super(hp, atk, def, mana, 0);
        this.name = name;
        this.gold = gold;
        this.exp = exp;
    }

    public Monster_Status(Monster_Status monster) {
        super(monster.get_Status());
        this.name = monster.name;
        this.gold = monster.gold;
        this.exp = monster.exp;
    }

    public String getName() {
        return this.name;
    }

    public int getGold() {
        return this.gold;
    }

    public int getExp() {
        return this.exp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}

