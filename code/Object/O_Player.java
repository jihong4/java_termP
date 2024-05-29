import  java.util.Random;
//기본 스탯만 저장하는 클래스. 최초에 한번 실행한 후, 이후엔 이 정보를 그대로 저장.
public class O_Player {
    Random rnd = new Random();
    private int HP;
    private int ATK;
    private int DEF;
    private int MANA;
    private int EXP;

    public O_Player(){
        this.HP = 20 + rnd.nextInt(6);
        this.ATK = 5 + rnd.nextInt(6);
        this.DEF = 5 + rnd.nextInt(6);
        this.MANA = 10 + rnd.nextInt(6);
        this.EXP = 0;
    }

    public OIS_Status getStatus(){
        return new OIS_Status(this.HP, this.ATK, this.DEF, this.MANA, this.EXP);
    }
}