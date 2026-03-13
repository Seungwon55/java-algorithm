package ch11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Practice11_01 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> kyo = new ArrayList<>();
        List<Integer> cha = new ArrayList<>();
        List<Integer> hap = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            list1.add(i);
        }
        for (int i = 3; i <= 6; i++) {
            list2.add(i);
        }

        // list1에서 list2에만 있는 값 제거
        kyo.addAll(list1);
        kyo.retainAll(list2);

        // list1에서 list2에도 있는 값 제거
        cha.addAll(list1);
        cha.removeAll(list2);

        // list2에서 cha 추가
        hap.addAll(list2);
        hap.addAll(cha);
        Collections.sort(hap);

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("kyo = " + kyo);
        System.out.println("cha = " + cha);
        System.out.println("hap = " + hap);
    }
}
