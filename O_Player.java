package TermProject;

import java.util.Random;

//기본 스탯만 저장하는 클래스. 최초에 한번 실행한 후, 이후엔 이 정보를 그대로 저장.
public class O_Player {
 Random rnd = new Random();
 private int HP;
 private int ATK;
 private int DEF;
 private int MANA;
 private int EXP;
 private int level;

 public O_Player() {
     this.HP = 20 + rnd.nextInt(6);
     this.ATK = 5 + rnd.nextInt(6);
     this.DEF = 5 + rnd.nextInt(6);
     this.MANA = 10 + rnd.nextInt(6);
     this.EXP = 0;
     this.level = 1;
 }

 public OIS_Status getStatus() {
     return new OIS_Status(this.HP, this.ATK, this.DEF, this.MANA, this.EXP);
 }

 public void addExperience(int exp) {
     this.EXP += exp;
     System.out.println("경험치를 " + exp + "만큼 획득했습니다. 현재 경험치: " + this.EXP);
     checkLevelUp();
 }

 private void checkLevelUp() {
     int requiredExp = level * 100; // 레벨업에 필요한 경험치
     while (EXP >= requiredExp) {
         levelUp();
         EXP -= requiredExp;
         requiredExp = level * 100;
     }
 }

 private void levelUp() {
     level++;
     HP += 10; // 레벨업 시 체력 증가
     ATK += 2; // 레벨업 시 공격력 증가
     DEF += 2; // 레벨업 시 방어력 증가
     MANA += 5; // 레벨업 시 마나 증가
     System.out.println("레벨업! 현재 레벨: " + level + ", HP: " + HP + ", ATK: " + ATK + ", DEF: " + DEF + ", MANA: " + MANA);
 }

 public void equipItem(O_Item item) {
     OIS_Status itemStats = item.getItem();
     this.HP += itemStats.HP;
     this.ATK += itemStats.ATK;
     this.DEF += itemStats.DEF;
     this.MANA += itemStats.MANA;
     System.out.println("아이템을 장착했습니다. 현재 상태: HP " + this.HP + ", ATK " + this.ATK + ", DEF " + this.DEF + ", MANA " + this.MANA);
 }

 public void attack(Monster_Status monster) {
     System.out.println("플레이어가 몬스터를 공격합니다.");
     monster.takeDamage(ATK);
     System.out.println("몬스터의 체력이 " + ATK + "만큼 감소했습니다. 남은 체력: " + monster.getHealth());
 }

 public void criticalAttack(Monster_Status monster) {
     if (MANA >= 10) {
         System.out.println("플레이어가 치명타 공격을 사용합니다.");
         monster.takeDamage(ATK * 2);
         MANA -= 10;
         System.out.println("몬스터의 체력이 " + (ATK * 2) + "만큼 감소했습니다. 남은 체력: " + monster.getHealth());
         System.out.println("플레이어의 남은 마나: " + MANA);
     } else {
         System.out.println("마나가 부족합니다. 일반 공격을 수행합니다.");
         attack(monster);
     }
 }

 public void skillAttack(Monster_Status monster) {
     if (MANA >= 15) {
         System.out.println("플레이어가 스킬 공격을 사용합니다.");
         monster.takeDamage(ATK * 2);
         MANA -= 15;
         System.out.println("몬스터의 체력이 " + (ATK * 2) + "만큼 감소했습니다. 남은 체력: " + monster.getHealth());
         System.out.println("플레이어의 남은 마나: " + MANA);
     } else {
         System.out.println("마나가 부족합니다. 일반 공격을 수행합니다.");
         attack(monster);
     }
 }

 public void defend() {
     System.out.println("플레이어가 방어 태세를 취합니다.");
     DEF += DEF / 2;
     System.out.println("플레이어의 방어력이 증가했습니다. 현재 방어력: " + DEF);
 }

 public void takeDamage(int damage) {
     int finalDamage = damage - DEF;
     if (finalDamage < 0) finalDamage = 0;
     HP -= finalDamage;
     System.out.println("플레이어가 " + finalDamage + "만큼의 피해를 입었습니다. 남은 체력: " + HP);
 }

 public boolean isAlive() {
     return HP > 0;
 }

 public int getMana() {
     return MANA;
 }

 public int getHealth() {
     return HP;
 }

 public void resetDefense() {
     DEF = DEF * 2 / 3; // 방어력이 원래대로 돌아갑니다.
 }
}
