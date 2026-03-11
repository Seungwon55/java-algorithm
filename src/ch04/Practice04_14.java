package ch04;

import java.util.Scanner;

public class Practice04_14 {
    public static void main(String[] args) {
        int answer = (int)(Math.random() * 100) + 1;
        int input = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);

        // 무한 반복문
        while (true) {
            count++;

            System.out.print("1과 100사이의 값을 입력하세요 : ");
            input = sc.nextInt();

            // 입력값과 정답 비교
            if (input > answer)
                System.out.println("더 작은 수를 입력하세요.");
            else if (input < answer)
                System.out.println("더 큰 수를 입력하세요.");
            else {   // 정답을 맞췄을 경우 반복문 종료
                System.out.println("정답입니다.");
                break;
                }
        }

        System.out.printf("시도횟수는 %d번입니다.", count);
    }
}
