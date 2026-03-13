package ch09;

public class Practice09_05 {
    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB", "AB"));
        System.out.println(count("12345", "AB"));
    }

    static int count(String src, String target) {
        int count = 0;   // 찾은 위치
        int pos = 0;   // 찾기 시작할 위치
        int targetLength = target.length();

        while (true) {
            pos = src.indexOf(target, pos);   // src에서 target의 위치

            // 못 찾을 경우 종료
            if (pos == -1)
                break;
            // 찾을 경우 count++와 pos 변경
            else {
                count++;
                pos += targetLength;
            }
        }

        return count;
    }
}
