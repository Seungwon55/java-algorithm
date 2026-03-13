package ch09;

public class Practice09_09 {
    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5) -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
        System.out.println("(1 2    3  4\t5) -> " + delChar("(1 2    3  4\t5)", " \t"));
    }

    static String delChar(String src, String delCh) {
        // 금지된 문자들을 제거한 문자열을 저장할 StringBuffer
        StringBuffer delSrc = new StringBuffer();

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (delCh.indexOf(c) == -1)
                delSrc.append(c);
        }

        return delSrc.toString();
    }
}
