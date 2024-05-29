// 객체지향프로그래밍 TermProject - JMT / Map 구현 / 202135764 류건우
package TermProject;

import java.util.Scanner;
import java.util.Random;

// Abstract map
abstract class map {
	abstract void enter();
}

// MapSelector
class MapSelector {
	public static int condition_boss = 0; // 보스 조건 여부
	public static int valid_choice = 1; // 올바른 선택 여부

	public static map selectNextmap() {
		Scanner keyboard = new Scanner(System.in);
		int choice;
		Random rand = new Random();
		int cases = rand.nextInt(4); // 무작위 case 실행
		System.out.println("------------------------------------");

		if (condition_boss >= 5)
			cases = 4; // 보스방 기준 충족 시 보스방 선택지

		switch (cases) {
		case 0:
			// 아이템_1, 몬스터_1
			do {
				System.out.println("갈림길이 나타났다.");
				System.out.println("왼쪽 길에서 스산한 바람이 불어온다.");
				System.out.println("오른쪽 길에는 알 수 없는 빛이 보인다.");
				System.out.println("어느 쪽으로 갈까? ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					condition_boss++;
					return new Itemmap_1();
				} else if (choice == 2) {
					condition_boss++;
					return new Monstermap_1();
				} else {
					System.out.println("잘못된 선택입니다. 다시 입력하세요.");
					System.out.println("------------------------------------");
				}
			} while (valid_choice == 1);
			break;

		case 1:
			// 트랩, 아이템_2, 몬스터_2
			do {
				System.out.println("세갈래길이 나타났다.");
				System.out.println("왼쪽 길 끝에 황금색 상자가 보인다.");
				System.out.println("가운데 길에서는 지속적으로 화살이 날아온다.");
				System.out.println("오른쪽 길에서는 희미하게 피 냄새가 난다.");
				System.out.println("어느 쪽으로 갈까? ('1' 또는 '2' 또는 '3'을 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					condition_boss++;
					return new Trapmap();
				} else if (choice == 2) {
					condition_boss++;
					return new Itemmap_2();
				} else if (choice == 3) {
					condition_boss++;
					return new Monstermap_2();
				} else {
					System.out.println("잘못된 선택입니다. 다시 입력하세요.");
					System.out.println("------------------------------------");
				}
			} while (valid_choice == 1);
			break;

		case 2:
			// 아이템_2, 트랩
			do {
				System.out.println("갈림길이 나타났다.");
				System.out.println("왼쪽 길로 흰색 고양이가 뛰어갔다.");
				System.out.println("오른쪽 길로는 검은색 고양이가 뛰어갔다.");
				System.out.println("어느 쪽으로 갈까? ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					condition_boss++;
					return new Itemmap_2();
				} else if (choice == 2) {
					condition_boss++;
					return new Trapmap();
				} else {
					System.out.println("잘못된 선택입니다. 다시 입력하세요.");
					System.out.println("------------------------------------");
				}
			} while (valid_choice == 1);
			break;

		case 3:
			// 몬스터_2, 아이템_1
			do {
				System.out.println("갈림길이 나타났다.");
				System.out.println("왼쪽 길에서 희미하게 웃음소리가 들린다.");
				System.out.println("오른쪽 길에서는 고약한 냄새가 난다.");
				System.out.println("어느 쪽으로 갈까? ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					condition_boss++;
					return new Monstermap_2();
				} else if (choice == 2) {
					condition_boss++;
					return new Itemmap_1();
				} else {
					System.out.println("잘못된 선택입니다. 다시 입력하세요.");
					System.out.println("------------------------------------");
				}
			} while (valid_choice == 1);
			break;

		case 4:
			// 보스
			do {
				System.out.println("어두운 기운이 느껴지는 큰 문이다.");
				System.out.println("들어가면 다시는 나올 수 없을 기분이 든다.");
				System.out.println("들어갈까? ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					condition_boss++;
					return new Bossmap();
				} else {
					System.out.println("도망칠 곳은 없다.");
					System.out.println("------------------------------------");
				}
			} while (valid_choice == 1);
			break;

		default:
			return new Errormap();
		}
		return new Errormap();
	}
}

// Error map
class Errormap extends map {
	void enter() {
		System.out.println("에러가 발생했습니다.");
		MapSelector.selectNextmap();
	}
}

// Start map
class Startmap extends map {
	void enter() {
		System.out.println("[JMT]");
		System.out.println("미궁에 들어왔다.");
		System.out.println("허공에서 아이템이 나타났다.");
		// 아이템 획득 로직 구현
		System.out.println("아이템을 획득했다.");
	}
}

// Monster map 1
class Monstermap_1 extends map {
	void enter() {
		System.out.println("몬스터가 등장했다!"); // 빛 관련 몬스터?
		// 전투 로직 구현
		System.out.println("몬스터를 처치했다.");
	}
}

// Monster map 2
class Monstermap_2 extends map {
	void enter() {
		System.out.println("몬스터가 등장했다!"); // 난폭한 종류?
		// 전투 로직 구현
		System.out.println("몬스터를 처치했다.");
	}
}

// Item map 1
class Itemmap_1 extends map {
	void enter() {
		System.out.println("새로운 아이템을 발견했다."); // 일반 아이템
		// 아이템 획득 로직 구현
	}
}

// Item map 2
class Itemmap_2 extends map {
	void enter() {
		System.out.println("희귀해 보이는 아이템을 발견했다."); // 레어 아이템
		// 아이템 획득 로직 구현
	}
}

// Trap map
class Trapmap extends map {
	void enter() {
		System.out.println("함정에 빠졌다!");
		// 체력 감소
		System.out.println("체력이 감소했다.");
	}
}

// Boss map
class Bossmap extends map {
	void enter() {
		System.out.println("미궁의 보스가 나타났다!");
		// 보스 전투 로직 구현
		System.out.println("보스를 물리쳤다!");
		System.out.println("[게임 클리어]");
	}
}

// Main
public class Dungeon_Map {
	public static void main(String[] args) {
		map currentMap = new Startmap();
		while (true) { // 게임 오버 시 추가 필요
			currentMap.enter();
			if (MapSelector.condition_boss >= 6)
				break;
			currentMap = MapSelector.selectNextmap();
		}
	}
}