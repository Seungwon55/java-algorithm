package ch08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice08_08 {
    public static void main(String[] args) {
        int answer = (int)(Math.random() * 100) + 1;
        int input = 0;
        int count = 0;

        do {
            System.out.print("1과 100사이의 값을 입력하세요 : ");
            // 숫자를 입력하지 않았을 경우의 예외 처리
            try {
                input = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
                continue;
            }
            count++;

            if (answer > input)
                System.out.println("더 큰 수를 입력하세요.");
            else if (answer < input)
                System.out.println("더 작은 수를 입력하세요.");
            else {
                System.out.println("정답입니다.");
                System.out.println("시도 횟수는 " + count + "번 입니다.");
                break;
            }
        }
        while (true);
    }
}
