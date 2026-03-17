package ch14;

import java.util.Random;

public class Practice14_07 {
    public static void main(String[] args) {
        // 로또 번호 출력
        new Random().ints(1, 46).distinct().limit(6).sorted().
                forEach(System.out::println);
    }
}
