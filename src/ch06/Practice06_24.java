package ch06;

public class Practice06_24 {
    public static void main(String[] args) {
        int value = 1;
        System.out.println(value + "의 절대값 : " + abs(value));
        value = -10;
        System.out.println(value + "의 절대값 : " + abs(value));
    }

    static int abs(int value) {
        if (value < 0)
            return value * -1;

        return value;
    }
}
