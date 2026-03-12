package ch06;

public class Practice06_22 {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));

        str = "1234o";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }

    static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);   // i번째 문자

            // 숫자가 아닐 경우
            if (c < '0' || c > '9')
                return false;
        }

        return true;
    }
}
