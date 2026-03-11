package ch04;

public class Practice04_13 {
    public static void main(String[] args) {
        String value = "12o34";
        char ch = ' ';
        boolean isNumber = true;

        // 문자열의 문자를 하나씩 읽어 숫자인지 검사
        for (int i = 0; i < value.length(); i++) {
            ch = value.charAt(i);   // i번째 문자 분리

            if (ch < '0' || ch > '9')   // 문자가 숫자가 아닌지 검사
                isNumber = false;
        }

        if (isNumber) {
            System.out.println(value + "는 숫자입니다.");
        }
        else {
            System.out.println(value + "는 숫자가 아닙니다.");
        }
    }
}
