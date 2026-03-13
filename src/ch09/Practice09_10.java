package ch09;

public class Practice09_10 {
    public static void main(String[] args) {
        String str = "가나다";

        System.out.println(format(str, 7, 0));
        System.out.println(format(str, 7, 1));
        System.out.println(format(str, 7, 2));
    }

    static String format(String str, int length, int alignment) {
        StringBuilder sb = new StringBuilder(length);

        int strLength = str.length();
        // 정렬을 위해 앞 공백 설정
        int blank = switch (alignment) {
            case 1 -> (length - strLength) / 2;
            case 2 -> length - strLength;
            default -> 0;
        };

        for (int i = 0; i < blank; i++)
            sb.append(" ");
        sb.append(str);

        return sb.toString();
    }
}
