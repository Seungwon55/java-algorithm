package ch14;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Practice14_06 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb","c", "dddd"};

        // 최대 길이의 문자열 계산
        int max = Arrays.stream(strArr).mapToInt(String::length).max().orElseThrow(NullPointerException::new);

        System.out.println("최대 길이 문자열 : " + max);
    }
}
