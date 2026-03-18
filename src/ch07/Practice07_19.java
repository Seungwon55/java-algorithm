package ch07;

public class Practice07_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());

        b.summary();
    }
}
class Product {
    private int price;

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "TV";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer {
    private int money = 1000;
    private Product[] cart = new Product[3];     // 구입한 제품을 저장하기 위한 배열
    private int i = 0;     // cart에 사용될 index

    void add(Product p) {
        if (i >= cart.length) {
            Product[] newCart = new Product[cart.length * 2];
            System.arraycopy(cart, 0, newCart, 0, cart.length);   // newCart에 기존 구매 제품 복사
            cart = newCart;   // 주소 복사
        }

        cart[i++] = p;  // 구매 제품 저장과 동시에 index 추가
    }

    void buy(Product p) {
        // 돈이 더 적다면 구매 불가능
        if (money < p.getPrice()) {
            System.out.println("잔액이 부족하여 " + p + "을/를 살 수 없습니다.");
            return;
        }

        money -= p.getPrice();
        add(p);
    }

    void summary() {
        StringBuilder itemList = new StringBuilder();   // 변경이 잦아 불변 클래스 String 대신 사용함
        int useMoney = 0;

        // 구매 목록, 사용 금액 초기화
        for (int j = 0; j < cart.length; j++) {
            itemList.append(cart[j]).append(", ");
            useMoney += cart[j].getPrice();
        }

        System.out.println("구입한 물건 : " + itemList);
        System.out.println("사용한 금액 : " + useMoney);
        System.out.println("남은 금액 :  " + money);
    }
}