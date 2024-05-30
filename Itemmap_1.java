package TermProject;

public class Itemmap_1 extends map {
    private Player player;

    public Itemmap_1(Player player) {
        this.player = player;
    }

    void enter() {
        Item weapon = new Item("강철 검", 10, 0);
        System.out.println("새로운 장비 발견!");
        player.addItem(weapon);
        System.out.println("강철 검 획득!");
    }
}
