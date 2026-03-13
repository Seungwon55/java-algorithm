package ch09;

public class Practice09_12 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(getRand(5, -3) + ", ");
        }
    }

    static int getRand(int from, int to) {
        int len = Math.abs(from - to) + 1;  // from 에서 to 까지의 범위 계산

        return (int)(Math.random() * len) + Math.min(from, to);
    }
}
