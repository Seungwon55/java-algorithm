package ch04;

public class Practice04_12 {
    public static void main(String[] args) {
        for (int x = 2; x <= 9; x += 3) {   // 2,5,8 시작 전 띄어쓰기 위한 반복문
            for (int i = 1; i <= 3; i++) {   // 1,2,3을 위한 반복문
                for (int j = x; j <= x+2 && j < 10; j++) {
                    System.out.printf("%d*%d=%d\t\t", j, i, j*i);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
