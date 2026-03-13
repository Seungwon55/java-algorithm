package ch11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Practice11_06 {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return (int) (s1.getAverage() - s2.getAverage());
            }
        });

        set.add(new Student("홍길동", 1,1,100,100,100));
        set.add(new Student("남궁성", 1,2,90,70,80));
        set.add(new Student("김자바", 1,3,80,80,90));
        set.add(new Student("이자바", 1,4,70,90,70));
        set.add(new Student("안자바", 1,5,60,100,80));

        Iterator<Student> it = set.iterator();

        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("[60~69] : " + getGroupCount(set,60 ,70));
        System.out.println("[70~79] : " + getGroupCount(set,70 ,79));
        System.out.println("[80~89] : " + getGroupCount(set,80 ,89));
        System.out.println("[90~100] : " + getGroupCount(set,90 ,100));
    }

    // 학생들의 평균이 해당 범위에 몇 명 있는지 파악하는 메서드
    static int getGroupCount(Set<Student> set, int from, int to) {
        int count = 0;
        Iterator<Student> students = set.iterator();

        // 각 학생의 평균이 범위에 포함되는지 확인
        while (students.hasNext()) {
            float avg = students.next().getAverage();
            if (avg >= from && avg <= to)
                count++;
        }

        return count;
    }
}
