package ch09;

public class Practice09_13 {
    public static void main(String[] args) {
        String src = "aabbccAABBCCaa";
        System.out.println(src);
        System.out.println("aa를 " + stringCount(src, "aa") + "개 찾았습니다.");
    }

    static int stringCount(String src, String key) {
        return stringCount(src, key, 0);
    }

    static int stringCount(String src, String key, int pos) {
        int count = 0;

        // 무한 반복문
        while (true) {
            pos = src.indexOf(key, pos);

            // indexOf의 값이 -1이면 무한 반복문 종료
            if (pos != -1) {
                pos += key.length();
                count++;
            }
            else break;
        }

        return count;
    }
}
