package ch04;

public class Practice04_08 {
    public static void main(String[] args) {
        for (int x = 0; x <= 10; x++) {   // x의 조건
            for (int y = 0; y <= 10; y++) {   // y의 조건
                if (2*x + 4*y == 10) {
                    System.out.printf("x=%d, y=%d\n", x, y);
                }
            }
        }
    }
}
