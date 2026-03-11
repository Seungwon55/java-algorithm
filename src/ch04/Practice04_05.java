package ch04;

public class Practice04_05 {
    public static void main(String[] args) {
        int i = 0;

        while (i <= 10) {   // 줄바꿈을 위한 while문
            int j = 0;
            while (j <= i) {   // *을 찍기 위한 while문
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
