package TermProject;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Item> inventory;

    public Player() {
        inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + "을(를) 인벤토리에 추가했습니다!");
    }

    public void showInventory() {
        System.out.println("현재 인벤토리:");
        for (Item item : inventory) {
            System.out.println(item);
        }
    }
}
