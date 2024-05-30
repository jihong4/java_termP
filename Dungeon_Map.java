package TermProject;

import java.util.Scanner;
import java.util.Random;

// Abstract map
abstract class map {
	abstract void enter();
}

// MapSelector
class MapSelector {
	public static int cases = 0;
	public static map selectNextmap() {
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int choice;
		
		System.out.println("-----------------------------------------------------------------------------");

		switch (cases) {
		case 0:
			// 아이템방_1, 몬스터방_1
			do {
				System.out.println("[갈림길이 나타났다.]");
				System.out.println("[왼쪽 길에서 스산한 바람이 불어온다.]");
				System.out.println("[오른쪽 길에는 알 수 없는 빛이 보인다.]");
				System.out.println("[어느 쪽으로 갈까?] ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					cases++;
					return new Itemmap_1();
				} else if (choice == 2) {
					cases++;
					return new Monstermap_1();
				} else {
					System.out.println("[잘못된 선택입니다. 다시 입력하세요.]");
					System.out.println("-----------------------------------------------------------------------------");
				}
			} while (true);

		case 1:
			// 트랩방, 아이템방_2, 몬스터방_2
			do {
				System.out.println("[세갈래길이 나타났다.]");
				System.out.println("[왼쪽 길 끝에 황금색 상자가 보인다.]");
				System.out.println("[가운데 길에서는 지속적으로 화살이 날아온다.]");
				System.out.println("[오른쪽 길에서는 희미하게 피 냄새가 난다.]");
				System.out.println("[어느 쪽으로 갈까?] ('1' 또는 '2' 또는 '3'을 입력)]");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					cases++;
					return new Trapmap();
				} else if (choice == 2) {
					cases++;
					return new Itemmap_2();
				} else if (choice == 3) {
					cases++;
					return new Monstermap_2();
				} else {
					System.out.println("[잘못된 선택입니다. 다시 입력하세요.]");
					System.out.println("-----------------------------------------------------------------------------");
				}
			} while (true);

		case 2:
			// 아이템방_3, 트랩방
			do {
				System.out.println("[갈림길이 나타났다.]");
				System.out.println("[왼쪽 길로 흰색 고양이가 뛰어갔다.]");
				System.out.println("[오른쪽 길로는 검은색 고양이가 뛰어갔다.]");
				System.out.println("[어느 쪽으로 갈까?] ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					cases++;
					return new Itemmap_3();
				} else if (choice == 2) {
					cases++;
					return new Trapmap();
				} else {
					System.out.println("[잘못된 선택입니다. 다시 입력하세요.]");
					System.out.println("-----------------------------------------------------------------------------");
				}
			} while (true);

		case 3:
			// 몬스터방_2, 아이템방_4
			do {
				System.out.println("[갈림길이 나타났다.]");
				System.out.println("[왼쪽 길에서 희미하게 웃음소리가 들린다.]");
				System.out.println("[오른쪽 길에서는 고약한 냄새가 난다.]");
				System.out.println("[어느 쪽으로 갈까?] ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					cases++;
					return new Monstermap_2();
				} else if (choice == 2) {
					cases++;
					return new Itemmap_4();
				} else {
					System.out.println("[잘못된 선택입니다. 다시 입력하세요.]");
					System.out.println("-----------------------------------------------------------------------------");
				}
			} while (true);
			
		case 4:
			// 몬스터방_3, 아이템방_5
			do {
				System.out.println("[갈림길이 나타났다.]");
				System.out.println("[왼쪽 길은 아주 고요하다.]");
				System.out.println("[오른쪽 길에서 지속적인 진동이 느껴진다.]");
				System.out.println("[어느 쪽으로 갈까?] ('1' 또는 '2'를 입력)]");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					cases++;
					return new Monstermap_3();
				} else if (choice == 2) {
					cases++;
					return new Itemmap_5();
				} else {
					System.out.println("[잘못된 선택입니다. 다시 입력하세요.]");
					System.out.println("-----------------------------------------------------------------------------");
				}
			} while (true);

		case 5:
			// 보스
			do {
				System.out.println("[어두운 기운이 느껴지는 큰 문이다.]");
				System.out.println("[들어가면 다시는 나올 수 없을 기분이 든다.]");
				System.out.println("[들어갈까?] ('1' 또는 '2'를 입력)");
				choice = keyboard.nextInt(); // 갈림길 선택 변수

				if (choice == 1) {
					cases++;
					return new Bossmap();
				} else {
					System.out.println("[도망칠 곳은 없다.]");
					System.out.println("-----------------------------------------------------------------------------");
				}
			} while (true);

		default:
			return new Errormap();
		}
	}
}

// Error map
class Errormap extends map {
	void enter() {
		System.out.println("[에러가 발생했습니다.]");
		MapSelector.selectNextmap();
	}
}

// Start map
class Startmap extends map {
	void enter() {
		// 대충 스토리
		System.out.println("[JMT]");
		System.out.println("과거 성역이었던 이곳은 100년 전 빛의 힘이 쇠약해진 틈을 타 어떤 암흑의 존재에 의해 점령되었다.");
		System.out.println("그 영향으로 이곳은 미궁이 되어 그 미지의 사악한 존재의 거처가 되었고,");
		System.out.println("내가 살던 고향은 미궁에 의한 저주의 지속적인 영향으로 이제는 더이상 사람이 살 수 없는 지경에 이르렀다.");
		System.out.println("이에 국왕께서는 누구든 이 미궁을 공략해내는 자에게 원하는 소원을 한 가지 들어주겠다는 명을 내리셨다.");
		System.out.println("나는 위대한 모험가였던 아버지의 뜻을 따라 이 미궁을 공략해내리라고 마음먹었다.");
		System.out.println("또한, 나는 반드시 이루어야만하는 소원이 있다. 그것은...");
		System.out.println("-----------------------------------------------------------------------------");
		
		// + 주인공 생성
		// + 랜덤 아이템 생성
		
		System.out.println("[미궁에 들어왔다.]");
		System.out.println("[허공에서 무언가가 나타났다.]");
		
		// + 아이템 획득
		
		System.out.println("[(아이템명)을 획득했다.]"); 	// + 아이템 이름
	}
}

// Monster map 1
class Monstermap_1 extends map {
	void enter() {
		System.out.println("[빛을 따라가니 (몬스터명)가 나타났다!]"); // + 빛 관련 몬스터?
		
		// + 전투 로직 구현
		
		System.out.println("[(몬스터명)를 처치했다.]");
		System.out.println("[레벨이 올랐다.]");
	}
}

// Monster map 2
class Monstermap_2 extends map {
	void enter() {
		System.out.println("[나를 발견한 (몬스터명) 무리가 다가온다!]"); // + 난폭한 종류?
		
		// + 전투 로직 구현
		
		System.out.println("[(몬스터명) 무리를 처치했다.]");
		System.out.println("[레벨이 올랐다.]");
	}
}

// Monster map 3
class Monstermap_3 extends map {
	void enter() {
		System.out.println("[거대한 악마 동상이 움직이기 시작했다!]"); // + 중간 보스급
		
		// + 전투 로직 구현
		
		System.out.println("[(몬스터명)를 처치했다.]");
		System.out.println("[레벨이 올랐다.]");
	}
}

// Item map 1
class Itemmap_1 extends map {
	void enter() {
		System.out.println("[바람이 불어오는 곳에서 (아이템명)을 발견했다.]"); // + 바람 관련 (공격력, 마나)
		
		// + 아이템 획득 로직 구현
		
		System.out.println("[새로운 아이템 (아이템명)을 획득했다.]");
		System.out.println("[한층 강해진 기분이 든다.]");
	}
}

// Item map 2
class Itemmap_2 extends map {
	void enter() {
		System.out.println("[험난한 길을 지나자 (아이템명)이 나타났다.]"); // 레어 아이템
		
		// + 아이템 획득 로직 구현
		
		System.out.println("[새로운 아이템 (아이템명)을 획득했다.]");
		System.out.println("[신비한 기운이 몸속을 맴돈다.]");
	}
}

// Item map 3
class Itemmap_3 extends map {
	void enter() {
		System.out.println("[고양이는 내가 마음에 드는 것 같다.]"); // + 고양이
		
		// + 아이템 획득 로직 구현
		
		System.out.println("[새로운 아이템 (아이템명)을 획득했다.]");
		System.out.println("[고양이는 귀엽다.]");
	}
}

// Item map 4
class Itemmap_4 extends map {
	void enter() {
		System.out.println("[책에서 본적있는 희귀한 약초를 찾았다.]"); // + 약초
		
		// + 아이템 획득 로직 구현
		
		System.out.println("[새로운 아이템 (아이템명)을 획득했다.]");
		System.out.println("[맛은 없었지만 정신이 아주 맑아졌다.]");
	}
}

//Item map 5
class Itemmap_5 extends map {
	void enter() {
		System.out.println("[이전 탐사대가 사용했던 장비들을 발견했다.]"); // + 장비
		
		// + 아이템 획득 로직 구현
		
		System.out.println("[새로운 아이템 (아이템명)을 획득했다.]");
		System.out.println("[쓸만한 물건은 이것밖에 없는 것 같다.]");
	}
}

// Trap map
class Trapmap extends map {
	void enter() {
		System.out.println("[함정에 빠졌다!]");
		
		// + 체력 감소
		
		System.out.println("[체력이 감소했다.]");
	}
}

// Boss map
class Bossmap extends map {
	void enter() {
		System.out.println("[미궁의 보스 (보스명)가 나타났다!]");
		
		// 보스 전투 로직 구현
		
		System.out.println("(보스명)를 물리쳤다!");
		System.out.println("[게임 클리어!]");
	}
}

// Main
public class Dungeon_Map {
	public static void main(String[] args) {
		map currentMap = new Startmap();
		while (true) { // 게임 오버 시 추가 필요
			currentMap.enter();
			if (MapSelector.cases >= 6)
				break;
			currentMap = MapSelector.selectNextmap();
		}
	}
}

// 전투팀 : 게임 오버 시 게임 종료, 한 맵에 복수의 몬스터
// 오브젝트팀 : 몬스터 및 아이템 이름
