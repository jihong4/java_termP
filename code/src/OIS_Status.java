public class OIS_Status {
    public int HP;
    public int ATK;
    public int DEF;
    public int MANA;
    public int EXP;
    public int level = 1;

    public OIS_Status(int hp, int atk, int def, int mana, int exp) {
        this.HP = hp;
        this.ATK = atk;
        this.DEF = def;
        this.MANA = mana;
        this.EXP = exp;
    }

    public OIS_Status(OIS_Status stat) {
        this.HP = stat.HP;
        this.ATK = stat.ATK;
        this.DEF = stat.DEF;
        this.MANA = stat.MANA;
        this.EXP = stat.EXP;
        this.level = stat.level;
    }

    public OIS_Status get_Status() {
        return new OIS_Status(this.HP, this.ATK, this.DEF, this.MANA, this.EXP);
    }

    public void setItem(OIS_Status item) {
        this.HP += item.HP;
        this.ATK += item.ATK;
        this.DEF += item.DEF;
        this.MANA += item.MANA;
    }

    public void add_EXP(int exp) {
        this.EXP += exp;
        checkLevelUp();
    }

    private void checkLevelUp() {
        while (true) {
            int requiredExp = level * 100;
            if (EXP >= requiredExp) {
                EXP -= requiredExp;
                levelUp(1);
            } else {
                break;
            }
        }
    }

    public void levelUp(int levels) {
        for (int i = 0; i < levels; i++) {
            System.out.println("Level UP!!");
            this.HP += 10;
            this.ATK += 5;
            this.DEF += 5;
            this.MANA += 3;
        }
        this.level += levels;
    }

    public int getLevel() {
        return this.level;
    }
}
