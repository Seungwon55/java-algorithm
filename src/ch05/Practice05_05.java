package ch05;

import java.util.Arrays;

public class Practice05_05 {
    public static void main(String[] args) {
        int[] ballArr = {1,2,3,4,5,6,7,8,9};
        int[] ball3 = new int[3];
        int tmp = 0;

        for (int i = 0; i < ballArr.length; i++) {
            int j = (int)(Math.random() * ballArr.length);

            // i번째 숫자와 j번째 숫자 교체
            tmp = ballArr[j];
            ballArr[j] = ballArr[i];
            ballArr[i] = tmp;
        }

        // 앞 3자리 ball3에 복사
        ball3 = Arrays.copyOf(ballArr, 3);

        // 3자리 숫자 출력
        for (int i = 0; i < ball3.length; i++) {
            System.out.print(ball3[i]);
        }
    }
}
