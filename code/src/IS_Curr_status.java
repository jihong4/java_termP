public class IS_Curr_status {
    private O_Player player;
    private O_Item item;
    private OIS_Status status;

    public IS_Curr_status(O_Player player, O_Item item, int exp) {
        this.player = player;
        this.item = item;
        this.status = player.getStatus();
        this.status.setItem(item.getItem());
        this.status.add_EXP(exp);
    }

    public OIS_Status getCurrentStatus() {
        return this.status;
    }

    public static void main(String[] args) {
        O_Player player = new O_Player();
        O_Item item = new O_Item(3);
        IS_Curr_status currentStatus = new IS_Curr_status(player, item, 550);
        OIS_Status status = currentStatus.getCurrentStatus();


        System.out.println("HP: " + status.HP);
        System.out.println("ATK: " + status.ATK);
        System.out.println("DEF: " + status.DEF);
        System.out.println("MANA: " + status.MANA);
        System.out.println("EXP: " + status.EXP);
        System.out.println("Level: " + status.getLevel());
    }
}
