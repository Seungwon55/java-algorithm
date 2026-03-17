package ch14;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Practice14_04 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 6).boxed().flatMap(i -> IntStream.rangeClosed(1, 6).mapToObj(j -> new int[]{i, j}))   // [1~6,1~6]배열 스트림 생성
                .filter(arr -> arr[0] + arr[1] == 6)   // 배열의 합이 6인 배열 필터링
                .forEach(arr -> System.out.println(Arrays.toString(arr)));   // 해당 배열 출력
    }
}
