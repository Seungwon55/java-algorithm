package ch04;

public class Practice04_11 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;

        System.out.print(num1 + "," + num2);   // 1,2번째 숫자 출력

        for (int i = 0; i < 8; i++) {
            num3 = num1 + num2;

            System.out.print("," + num3);

            num1 = num2;   // 1,2번째 숫자 변경
            num2 = num3;
        }
    }
}
