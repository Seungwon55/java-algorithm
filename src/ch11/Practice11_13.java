package ch11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice11_13 {
    public static void main(String[] args) throws Exception {
        SutdaDeck deck = new SutdaDeck();

        deck.shuffle();

        Player[] players = {
                new Player("타짜", deck.pick(), deck.pick()),
                new Player("고수", deck.pick(), deck.pick()),
                new Player("물주", deck.pick(), deck.pick()),
                new Player("중수", deck.pick(), deck.pick()),
                new Player("하수", deck.pick(), deck.pick())
        };

        // 점수 부여
        for (int i = 0; i < players.length; i++) {
            players[i].point = deck.getPoint(players[i]);
        }

        Arrays.sort(players);   // 순위 매기기
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
        }

        System.out.println("1위는 " + players[0] + "입니다.");
    }
}

class Player implements Comparable<Player> {
    String name;
    SutdaCard card1;
    SutdaCard card2;
    int point;

    public Player(String name, SutdaCard card1, SutdaCard card2) {
        this.name = name;
        this.card1 = card1;
        this.card2 = card2;
    }

    @Override
    public String toString() {
        return "[" + name + "]" + card1 + ", " + card2;
    }

    @Override
    public int compareTo(Player p) {
        return p.point - point;
    }
}

class SutdaDeck {
    static final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    int pos = 0;   // 다음 가져올 카드 위치
    Map<String, Integer> jokbo = new HashMap<>();

    // 기본 카드 세팅 생성자
    SutdaDeck() {
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);

            cards[i] = new SutdaCard(num, isKwang);
        }

        registerJokbo();
    }

    // 족보 저장 메서드
    void registerJokbo() {
        int score = 3100;

        // 광땡 족보 설정
        jokbo.put("KK", 4000);
        // 땡 족보 설정
        for (int i = 10; i > 0; i--) {
            String num = String.valueOf(i);
            jokbo.put(num + num, score);
            score -= 10;
        }
        jokbo.put("12", 2060);
        jokbo.put("21", 2060);
        jokbo.put("14", 2050);
        jokbo.put("41", 2050);
        jokbo.put("19", 2040);
        jokbo.put("91", 2040);
        jokbo.put("110", 2030);
        jokbo.put("101", 2030);
        jokbo.put("410", 2020);
        jokbo.put("104", 2020);
        jokbo.put("46", 2010);
        jokbo.put("64", 2010);
    }

    int getPoint(Player p) {
        if (p == null)
            return 0;

        SutdaCard card1 = p.card1;
        SutdaCard card2 = p.card2;

        Integer result = 0;

        // 광땡
        if (card1.isKwang && card2.isKwang)
            result = jokbo.get("KK");
        // 족보
        else {
            String score = String.valueOf(card1.num) + String.valueOf(card2.num);
            result = jokbo.get(score);
        }
        // 족보가 없을 때
        if (result == null)
            result = (card1.num + card2.num) % 10 + 1000;

        p.point = result;

        return result;
    }

    // 카드를 뽑는 메서드
    SutdaCard pick() throws Exception {
        SutdaCard card = null;

        // 카드를 뽑고 해당 위치의 카드를 없앤다.
        if (pos >= 0 && pos <= CARD_NUM) {
            card = cards[pos];
            cards[pos++] = null;
        }
        else
            throw new Exception("남아있는 카드가 없습니다.");

        return card;
    }

    // 카드를 섞는 메서드
    void shuffle() {
        for (int i = 0; i < CARD_NUM; i++) {
            int num = (int)(Math.random() * CARD_NUM);

            SutdaCard tmp = cards[i];
            cards[i] = cards[num];
            cards[num] = tmp;
        }
    }
}