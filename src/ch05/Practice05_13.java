package ch05;

import java.util.Scanner;

public class Practice05_13 {
    public static void main(String[] args) {
        String[] words = {"television", "computer", "mouse", "phone"};
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            // String을 char[]로 변환
            char[] question = words[i].toCharArray();

            // 문자 섞기
            for (int j = 0; j < question.length; j++) {
                int random = (int) (Math.random() * (question.length));

                char tmp = question[j];
                question[j] = question[random];
                question[random] = tmp;
            }

            System.out.printf("Q%d. %s의 정답을 입력하세요. > ", i+1, new String(question));
            String answer = sc.nextLine();

            if (words[i].equals(answer.trim()))
                System.out.println("맞았습니다.");
            else
                System.out.println("틀렸습니다.");
        }
    }
}
