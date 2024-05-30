package TermProject;

public class Itemmap_4 extends map {
    private Player player;

    public Itemmap_4(Player player) {
        this.player = player;
    }

    void enter() {
        Item accessory = new Item("고대의 반지", 20, 20);
        System.out.println("희귀 장비 발견!");
        player.addItem(accessory);
        System.out.println("고대의 반지 획득!");
    }
}
