package ch11;

import java.util.*;

public class Practice11_14 {
    static Scanner sc = new Scanner(System.in);
    static List<Student3> students = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        // !!!!! 메인메뉴(사용자 입력 받아서 1이면 학생성적 입력 등등)도 메서드로 작성 !!!!!
        while (true) {
            System.out.println("*****************************************");
            System.out.println("*           성적 관리 프로그램              *");
            System.out.println("*****************************************");
            System.out.println();
            System.out.println("1. 학생성적 입력하기");
            System.out.println();
            System.out.println("2. 학생성적 보기");
            System.out.println();
            System.out.println("3. 프로그램 종료");
            System.out.println();
            System.out.print("원하는 메뉴를 선택하세요.(1~3) : ");
            int menuNum = sc.nextInt();

            switch (menuNum) {
                case 1:
                    inputStuInfo();
                    break;
                case 2:
                    printStuInfo();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    // 1번 입력 시 학생 성적 입력하여 학생 리스트에 학생 추가하는 메서드
    static void inputStuInfo() {
        while (true) {
            System.out.println("1. 학생성적 입력하기");
            System.out.println("이름, 반, 번호, 국어, 영어, 수학의 순서로 공백없이 입력하세요.");
            System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");

            System.out.print(">> ");
            String input = sc.next();

            // 사용자 입력 값 유효성 검사
            try {
                if (input.equalsIgnoreCase("q")) {
                    // 메인메뉴로 돌아가기
                    break;
                } else {
                    System.out.println("잘 입력 되었습니다.");
                    Scanner sc2 = new Scanner(input).useDelimiter(",");
                    Student3 student = new Student3(sc2.next(), sc2.nextInt(), sc2.nextInt(), sc2.nextInt(), sc2.nextInt(), sc2.nextInt());
                    // !!! List(학생 집합)에 student 넣기
                    students.add(student);
                }
            } catch (NoSuchElementException e) {
                System.out.println("입력 오류입니다.");
                continue;
            }
        }
    }

    // 2번 입력 시 학생 정보 출력하는 메서드
    static void printStuInfo() {
        Iterator<Student3> it = students.iterator();

        System.out.println("==============================");
        if (it.hasNext()) {
            while (it.hasNext())
                System.out.println(it.next());
        }
        else
            System.out.println("데이터가 없습니다.");
        System.out.println("==============================");
    }
}

class Student3 implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;
    int total;
    double average;

    public Student3(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.total = getTotal();
        this.average = getAverage();
    }

    int getTotal() {
        return kor + eng + math;
    }

    double getAverage() {
        return getTotal() / 3.0;
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
                '}';
    }

    @Override
    public int compareTo(Object o1) {
        if (o1 instanceof Student) {
            Student s1 = (Student) o1;

            if (this.ban != s1.ban)
                return this.ban - s1.ban;
            return this.no - s1.no;
        }
        return -1;
    }
}
