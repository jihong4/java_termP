public class Monsters1to5 extends Monster_Status {
    public Monsters1to5() {
        super("", 0, 0, 0, 0, 0);
    }

    public static class Monster1 extends Monster_Status {
        public Monster1() {
            super("Monster1", 50, 10, 5, 0, 20);
        }
    }

    public static class Monster2 extends Monster_Status {
        public Monster2() {
            super("Monster2", 70, 15, 8, 0, 30);
        }
    }

    public static class Monster3 extends Monster_Status {
        public Monster3() {
            super("Monster3", 90, 20, 10, 0, 40);
        }
    }

    public static class Monster4 extends Monster_Status {
        public Monster4() {
            super("Monster4", 110, 25, 12, 0, 50);
        }
    }

    public static class Monster5 extends Monster_Status {
        public Monster5() {
            super("Monster5", 130, 30, 15, 0, 60);
        }
    }
}