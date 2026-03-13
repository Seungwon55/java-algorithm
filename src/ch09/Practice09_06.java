package ch09;

public class Practice09_06 {
    public static void main(String[] args) {
        String src = "12345";

        System.out.println(fillZero(src, 10));
        System.out.println(fillZero(src, -1));
        System.out.println(fillZero(src, 3));
    }

    static String fillZero(String src, int length) {
        int srcLength = src.length();

        if (srcLength == length)
            return src;
        else if (length <= 0)
            return "";
        else if (srcLength > length)
            return src.substring(0, length);

        StringBuffer sf = new StringBuffer(length);

        // sf에 length - srcLength 만큼 0 추가
        for (int i = 0; i < length - srcLength; i++)
            sf.append("0");
        // sf에 src 추가
        sf.append(src);

        return sf.toString();
    }
}
