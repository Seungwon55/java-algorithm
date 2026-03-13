package ch11;

import java.util.*;

public class Practice11_07 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("홍길동", 1,3,100,100,100));
        list.add(new Student("남궁성", 1,1,90,70,80));
        list.add(new Student("김자바", 1,2,80,80,90));
        list.add(new Student("이자바", 2,1,70,90,70));
        list.add(new Student("안자바", 2,2,60,100,80));

        Collections.sort(list, new BanNoAscending());   // BanNoAscending 정렬 기준을 통해 정렬

        Iterator<Student> it = list.iterator();

        while (it.hasNext())
            System.out.println(it.next());
    }
}

class BanNoAscending implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // ban이 같을 경우 no로 비교
        if (s1.ban == s2.ban)
            return s1.no - s2.no;

        // ban이 다를 경우 ban으로 비교
        return s1.ban - s2.ban;
    }
}