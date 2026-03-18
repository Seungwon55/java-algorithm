package ch09;

public class Practice09_08 {
    public static void main(String[] args) {
        System.out.println(round(3.1415, 1));
        System.out.println(round(3.1415, 2));
        System.out.println(round(3.1415, 3));
        System.out.println(round(3.1415, 4));
        System.out.println(round(3.1415, 5));

    }

    static double round(double d, int n) {
        double i = Math.pow(10, n);   // 소수점 자리수를 위해 곱하고 나눌 수

        return Math.round(d * i) / i;
    }
}
