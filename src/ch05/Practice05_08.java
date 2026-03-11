package ch05;

public class Practice05_08 {
    public static void main(String[] args) {
        int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
        int[] counter = new int[4];

        // counter 배열에 개수 작성
        for (int i = 0; i < answer.length; i++) {
            counter[answer[i] - 1]++;
        }

        for (int i = 0; i < counter.length; i++) {
            // counter[i] 숫자 출력
            System.out.print(counter[i]);
            // counter[i] 숫자만큼 '*'출력
            for (int j = 0; j < counter[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
