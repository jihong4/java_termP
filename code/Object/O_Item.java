public class O_Item {
    private int HP;
    private int ATK;
    private int DEF;
    private int MANA;

    public O_Item(int mode){
        if(mode == 1) Item1();
        else if (mode == 2) Item2();
        else if (mode == 3) Item3();
        else if (mode == 4) Item4();
        else if (mode == 5) Item5();
        else System.out.println("Wrong Item mode"); //need Exeption11
    }

    public void Item1(){
        this.HP = 2;
        this.ATK = 0;
        this.DEF = 1;
        this.MANA = 0;
    }
    public void Item2(){
        this.HP = 2;
        this.ATK = 5;
        this.DEF = 3;
        this.MANA = 7;
    }
    public void Item3(){
        this.HP = 5;
        this.ATK = 4;
        this.DEF = 7;
        this.MANA = 3;
    }
    public void Item4(){
        this.HP = 4;
        this.ATK = 8;
        this.DEF = 2;
        this.MANA = 10;
    }
    public void Item5(){
        this.HP = 5;
        this.ATK = 12;
        this.DEF = 7;
        this.MANA = 13;
    }

    public OIS_Status getItem(){
        return new OIS_Status(this.HP, this.ATK, this.DEF, this.MANA, 0);
    }

    public OIS_Status chgItem(int mode){
        if(mode == 1) Item1();
        else if (mode == 2) Item2();
        else if (mode == 3) Item3();
        else if (mode == 4) Item4();
        else if (mode == 5) Item5();
        else System.out.println("Wrong Item mode"); //need Exeption

        return getItem();
    }
}
