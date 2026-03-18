package ch09;

public class Practice09_01 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3,true);
        SutdaCard c2 = new SutdaCard(3,true);

        System.out.println("c1 : " + c1);
        System.out.println("c2 : " + c2);
        System.out.println("c1.equals(c2) : " + c1.equals(c2));
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    public SutdaCard() {
        this(1, true);
    }

    public SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // 주소값이 아닌 iv의 값을 비교하기 위해 오버라이딩
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard card)
            return card.num == num && card.isKwang == isKwang;

        return false;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}
