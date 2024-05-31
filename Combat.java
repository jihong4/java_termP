package TermProject;

import java.util.Scanner;

public class Combat {
    private O_Player player;
    private Monster_Status monster;
    private Scanner scanner;

    public Combat(O_Player player, Monster_Status monster) {
        this.player = player;
        this.monster = monster;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("전투가 시작됩니다! 상대는 " + monster.getName() + "입니다.");

        while (player.isAlive() && monster.isAlive()) {
            playerTurn();
            if (!monster.isAlive()) break;
            monsterTurn();
            player.resetDefense(); // 방어력 초기화
        }

        if (player.isAlive() && !monster.isAlive()) {
            System.out.println("플레이어가 승리했습니다!");
            player.addExperience(monster.getExp());
        } else if (!player.isAlive()) {
            System.out.println("플레이어가 패배했습니다...");
            System.exit(0); // 게임 종료
        }
    }

    private void playerTurn() {
        System.out.println("플레이어의 턴입니다. 선택지를 고르세요:");
        System.out.println("1. 일반 공격");
        System.out.println("2. 치명타 공격");
        System.out.println("3. 스킬 공격");
        System.out.println("4. 방어");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                player.attack(monster);
                break;
            case 2:
                player.criticalAttack(monster);
                break;
            case 3:
                player.skillAttack(monster);
                break;
            case 4:
                player.defend();
                break;
            default:
                System.out.println("잘못된 입력입니다. 공격을 놓쳤습니다.");
        }
    }

    private void monsterTurn() {
        if (monster.isAlive()) {
            System.out.println("몬스터의 턴입니다.");
            monster.attack(player);
        }
    }

    public Monster_Status getMonster() {
        return monster;
    }
}
