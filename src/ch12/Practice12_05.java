package ch12;

import java.util.ArrayList;
import java.util.List;

public class Practice12_05 {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = deck.pick(0);
        System.out.println(card);

        deck.shuffle();
        card = deck.pick(0);
        System.out.println(card);
    }
}

// 카드의 모양
enum Kind {
    CLOVER, HEART, DIAMOND, SPACE
}

// 카드 숫자
enum Number {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

class Card {
    Kind kind;   // 카드 모양 -> enum으로 선언
    Number num;  // 카드 숫자 -> enum으로 선언

    Card() {
        this(Kind.SPACE, Number.ACE);
    }

    Card(Kind kind, Number num) {
        this.kind = kind;
        this.num = num;
    }

    @Override
    public String toString() {
        return "[" + kind + "," + num + "]";
    }
}

class Deck {
    final int CARD_NUM = Kind.values().length * Number.values().length;
    Card[] cards = new Card[CARD_NUM];

    Deck() {
        int index = 0;

        for (Kind kind : Kind.values()) {
            for (Number num : Number.values())
                cards[index++] = new Card(kind, num);
        }
    }

    // 카드 랜덤 뽑기
    Card pick() {
        int index = (int)(Math.random() * CARD_NUM);
        return pick(index);
    }

    // 해당 위치의 카드 뽑기
    Card pick(int index) {
        return cards[index];
    }

    // 카드 섞기
    void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int r = (int) (Math.random() * CARD_NUM);

            Card tmp = cards[i];
            cards[i] = cards[r];
            cards[r] = tmp;
        }
    }
}