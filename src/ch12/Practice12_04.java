package ch12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Practice12_04 {
    public static void main(String[] args) {
        Product coffee = new Product("커피", 2000);
        Product shirt = new Product("셔츠", 25000);

        List<Product> list1 = new ArrayList<>();
        List<Product> list2 = new ArrayList<>();

        list1.add(coffee);
        list2.add(shirt);

        List<Product> mergeList = merge(list1, list2);
        Iterator<Product> iterator = mergeList.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
    // 제네릭 메서드(두 리스트를 합치는 메서드)
    static <T extends Product>List<T> merge(List<T> list1, List<T> list2) {
        List<T> newList = new ArrayList<>(list1);

        newList.addAll(list2);

        return newList;
    }
}

class Product {
    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "(가격:" + price + "원)";
    }
}