public class IS_Fighting {
    private int HP;
    private int ATK;
    private int DEF;
    private int MANA;

    public IS_Fighting(IS_Curr_status curr){
        OIS_Status stat =new OIS_Status(curr.getCurrentStatus());
        this.HP = stat.HP;
        this.ATK = stat.ATK;
        this.DEF = stat.DEF;
        this.MANA = stat.MANA;
    }

    public void Damage(int h, int a, int d, int m){
        this.HP -= h;
        this.ATK -= a;
        this.DEF -= d;
        this.MANA -= m;

        if(this.HP <= 0) System.out.println("HP가 " + this.HP + "가 되었습니다.");
        if(this.ATK <= 0) System.out.println("ATK가 " + this.ATK + "가 되었습니다.");
        if(this.DEF <= 0) System.out.println("DEF가 " + this.DEF + "가 되었습니다.");
        if(this.MANA <= 0) System.out.println("MANA가 " + this.MANA + "가 되었습니다.");
    }

}
