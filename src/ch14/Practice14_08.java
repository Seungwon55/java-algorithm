package ch14;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice14_08 {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),

                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200),
        };

        // 150점 이하 학생 성별로 나눈 수
        Map<Boolean, Long> failedStuBySex = Arrays.stream(students).filter(s -> s.getScore() < 150).
                collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));

        System.out.printf("불합격[남자] : %d명\n", failedStuBySex.get(true));
        System.out.printf("불합격[여자] : %d명", failedStuBySex.get(false));
    }
}

class Student implements Comparable<Student> {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    String getName() {
        return name;
    }

    boolean isMale() {
        return isMale;
    }

    int getHak() {
        return hak;
    }

    int getBan() {
        return ban;
    }

    int getScore() {
        return score;
    }


    @Override
    public int compareTo(Student s) {
        return name.compareTo(s.name);
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %d점]", name, isMale ? "남":"여", hak, ban, score);
    }
}