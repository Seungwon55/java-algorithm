package ch07;

public class Practice07_02 {
    public static void main(String[] args) throws Exception {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (int i = 0; i < deck.CARD_NUM; i++) {
            System.out.print(deck.cards[i] + ",");
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }
}

class SutdaCard {
    final int NUM;
    final boolean IS_KWANG;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.NUM = num;
        this.IS_KWANG = isKwang;
    }

    @Override
    public String toString() {
        return NUM + (IS_KWANG ? "K" : "");
    }
}

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    // 섯다 카드 초기화
    SutdaDeck() {
        for (int i = 0; i < CARD_NUM; i++) {
            boolean isKwang = i == 0 || i == 2 || i == 7;

            cards[i] = new SutdaCard(i % 10 + 1, isKwang);
        }
    }

    // 카드 순서를 섞는 메서드
    void shuffle() {
        for (int i = 0; i < CARD_NUM; i++) {
            int random = (int) (Math.random() * CARD_NUM);

            SutdaCard tmp = cards[i];
            cards[i] = cards[random];
            cards[random] = tmp;
        }
    }

    // 랜덤한 카드를 뽑는 메서드
    SutdaCard pick() {
        return cards[(int)(Math.random() * CARD_NUM)];
    }

    // 지정된 위치의 카드를 뽑는 메서드
    SutdaCard pick(int index) throws Exception {
        if (index >= 20) {
            throw new Exception("카드는 20장만 존재합니다.");
        }

        return cards[index];
    }
}
