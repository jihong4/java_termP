package TermProject;

public class Itemmap_2 extends map {
    private Player player;

    public Itemmap_2(Player player) {
        this.player = player;
    }

    void enter() {
        Item hat = new Item("강철 투구", 0, 5);
        Item armor = new Item("강철 갑옷", 0, 20);
        System.out.println("새로운 장비 발견!");
        player.addItem(hat);
        player.addItem(armor);
        System.out.println("투구와 갑옷 획득!");
    }
}
