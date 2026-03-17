package ch14;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Practice14_05 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb","c", "dddd"};

        // IntStream으로 변경 후 최종 연산
        int sum = Arrays.stream(strArr).mapToInt(String::length).sum();

        System.out.println("sum = " + sum);
    }
}
