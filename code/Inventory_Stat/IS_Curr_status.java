public class IS_Curr_status {
    private int HP;
    private int ATK;
    private int DEF;
    private int MANA;
    private int EXP;

    public OIS_Status IS_Curr_status(OIS_Status pl, O_Item tem, int exp){
        pl.setItem(tem.getItem());
        pl.add_EXP(exp);

        pl = pl.get_Status();

        return pl;
    }


}