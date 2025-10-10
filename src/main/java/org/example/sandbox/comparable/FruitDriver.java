package org.example.sandbox.comparable;

import java.util.ArrayList;
import java.util.List;

public class FruitDriver {
    public static void main(String[] args) {
        Fruit fruit1 = Fruit.builder()
                .name("Apple")
                .color("Red")
                .weight(0.5)
                .price(1.2)
                .quantity(10)
                .build();

        Fruit fruit2 = Fruit.builder()
                .name("Banana")
                .color("Yellow")
                .weight(0.3)
                .price(0.8)
                .quantity(20)
                .build();

        Fruit fruit3 = Fruit.builder()
                .name("Orange")
                .color("Orange")
                .weight(0.4)
                .price(1.0)
                .quantity(15)
                .build();

        Fruit fruit4 = Fruit.builder()
                .name("Grapes")
                .color("Purple")
                .weight(0.2)
                .price(2.0)
                .quantity(8)
                .build();

        Fruit fruit5 = Fruit.builder()
                .name("Mango")
                .color("Yellow")
                .weight(0.6)
                .price(1.5)
                .quantity(12)
                .build();


        List<Fruit> fruitList = new ArrayList<>();

        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        fruitList.add(fruit4);
        fruitList.add(fruit5);

        fruitList.sort(Fruit::compareTo);
        fruitList.forEach(System.out::println);


    }
}
