package ch09;

import java.util.Scanner;

public class Practice09_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("시작 단과 끝 단, 두 개의 정수를 입력해주세요.(범위 2~9) : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        gugudan(num1, num2);
    }

    static void gugudan(int num1, int num2) {
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        for (int i = min; i <= max; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d*%d=%d\n", i, j, i*j);
            }
            System.out.println();
        }
    }
}
