package TermProject;

public class Itemmap_3 extends map {
    private Player player;

    public Itemmap_3(Player player) {
        this.player = player;
    }

    void enter() {
        Item shoes = new Item("신속 장화", 0, 3);
        System.out.println("새로운 장비 발견!.");
        player.addItem(shoes);
        System.out.println("신속 장화 획득!.");
    }
}
