package ch05;

import java.util.Scanner;

public class Practice05_06 {
    public static void main(String[] args) {
        int[] coinUnit = {500, 100, 50, 10};
        
        Scanner sc = new Scanner(System.in);
        System.out.print("기본 자금 : ");
        int money = sc.nextInt();

        for (int i = 0; i < coinUnit.length; i++) {
            int quantity = money / coinUnit[i];
            money %= coinUnit[i];

            System.out.println(coinUnit[i] + "원 : " + quantity + "개");
        }
    }
}
