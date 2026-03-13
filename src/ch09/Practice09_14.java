package ch09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice09_14 {
    public static void main(String[] args) {
        String[] phoneNumArr = {
                "012-3456-7890",
                "099-2456-7980",
                "088-2346-9870",
                "013-3456-7890"
        };
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 번호 입력
            System.out.print("번호를 입력하세요(종료:q) : ");
            String input = sc.next();

            // 번호가 빈 문자열이면 다시 번호 입력, q면 번호 입력 종료
            if (input.equals(""))
                continue;
            else if (input.equalsIgnoreCase("q"))
                break;

            // input이 phoneNumArr에 있으면 list에 저장
            for (int i = 0; i < phoneNumArr.length; i++) {
                String phoneNum = phoneNumArr[i].replaceAll("-", "");
                if (phoneNum.contains(input))
                    list.add(phoneNumArr[i]);
            }

            // 번호 출력
            if (list.size() > 0) {
                System.out.println(list);
                list.clear();
            }
            else {
                System.out.println("일치하는 번호가 없습니다.");
            }
        }
    }
}
