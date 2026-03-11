package ch05;

public class Practice05_09 {
    public static void main(String[] args) {
        char[][] star = {
                {'*','*',' ',' ',' '},
                {'*','*',' ',' ',' '},
                {'*','*','*','*','*'},
                {'*','*','*','*','*'}
        };
        char[][] result = new char[star[0].length][star.length];

        // 시계방향 전환
        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[i].length; j++) {
                result[j][i] = star[star.length - i - 1][j];
            }
        }

        // char[][] result 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
