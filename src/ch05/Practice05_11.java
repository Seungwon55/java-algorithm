package ch05;

public class Practice05_11 {
    public static void main(String[] args) {
        int[][] score = {
                {100,100,100}
                ,{20,20,20}
                ,{30,30,30}
                ,{40,40,40}
                ,{50,50,50}
        };
        int[][] result = new int[score.length + 1][score[0].length + 1];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                // score[i][j] 내용 그대로 복사
                result[i][j] = score[i][j];
                // 열의 총합 계산
                result[i][score[i].length] += score[i][j];
                // 행의 총합 계산
                result[score.length][j] += score[i][j];
            }

            // 모든 값의 총합 계산
            result[score.length][score[i].length] += result[i][score[i].length];
        }

        // 결과 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%4d", result[i][j]);
            }
            System.out.println();
        }
    }
}
