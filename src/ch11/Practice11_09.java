package ch11;

import java.util.*;

public class Practice11_09 {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("김자바", 1,2,80,80,90));
        list.add(new Student1("홍길동", 1,3,100,100,100));
        list.add(new Student1("이자바", 2,1,70,90,70));
        list.add(new Student1("남궁성", 1,1,90,70,80));
        list.add(new Student1("안자바", 2,2,60,100,80));
        list.add(new Student1("서자바", 2,2,60,90,85));
        list.add(new Student1("최자바", 2,2,80,100,80));

        calculateSchoolRank(list);
        calculateClassRank(list);

        Iterator<Student1> it = list.iterator();

        while (it.hasNext())
            System.out.println(it.next());
    }

    // 전교 등수를 부여하는 메서드
    static void calculateSchoolRank(List<Student1> list) {
        Collections.sort(list);   // 총점기준 내림차순

        int prevRank = 0;   // 이전 전교등수
        int prevTotal = -1;   // 이전 총점
        int length = list.size();
        Iterator<Student1> students = list.iterator();

        while (students.hasNext()) {
            Student1 student = students.next();

            // 총점이 같다면 같은 등수
            if (prevTotal == student.total)
                student.schoolRank = prevRank;
            else {
                student.schoolRank = ++prevRank;
                prevTotal = student.total;
            }
        }
    }

    // 반등수를 부여하는 메서드
    static void calculateClassRank(List<Student1> list) {
        Collections.sort(list, new ClassTotalComparator());   // 반과 총점으로 정렬

        int prevBan = -1;
        int prevRank = 0;
        int prevTotal = -1;
        int length = list.size();
        Iterator<Student1> students = list.iterator();

        while (students.hasNext()) {
            Student1 student = students.next();

            // 반이 달리지면
            if (prevBan != student.ban) {
                prevTotal = -1;   // 총점 초기화
                prevRank = 0;   // 등수 초기화
                prevBan = student.ban;   // 반 재설정
                // 총점이 같다면
                if (prevTotal == student.total)
                    student.classRank = prevRank;
                // 총점이 다르면
                else {
                    student.classRank = ++prevRank;
                    prevTotal = student.total;
                }
            }
            // 반이 같다면
            else {
                if (prevTotal == student.total)
                    student.classRank = prevRank;
                    // 총점이 다르면
                else {
                    student.classRank = ++prevRank;
                    prevTotal = student.total;
                }
            }
        }
    }
}

class Student1 implements Comparable<Student1> {
    String name;
    int ban;
    int no;
    int kor, eng, math;
    int total;
    int schoolRank;
    int classRank;

    public Student1(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.total = getTotal();
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", no=" + no +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", total=" + total +
                ", schoolRank=" + schoolRank +
                ", classRank=" + classRank +
                '}';
    }

    // 총점을 통해 정렬하도록 설정
    @Override
    public int compareTo(Student1 s) {
        return s.total - total;
    }
}

// 반과 총점으로 정렬하는 Comparator
class ClassTotalComparator implements Comparator<Student1> {
    @Override
    public int compare(Student1 s1, Student1 s2) {
        // 반이 같다면 총점으로 내림차순
        if (s1.ban == s2.ban)
            return s2.total - s1.total;
        // 반으로 오름차순
        return s1.ban - s2.ban;
    }
}