package ch11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Practice11_11 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);
        SutdaCard c3 = new SutdaCard(1, true);

        Set<SutdaCard> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    public SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard)
            return num == ((SutdaCard) obj).num && isKwang == ((SutdaCard) obj).isKwang;

        return false;
    }

    // equals 오버라이딩 시 hashCode도 오버라이딩 해야한다.
    @Override
    public int hashCode() {
        return Objects.hash(num, isKwang);   // num, isKwang이 같으면 같은 해시코드 출력
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}