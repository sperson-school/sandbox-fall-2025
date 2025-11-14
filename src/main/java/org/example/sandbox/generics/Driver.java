package org.example.sandbox.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        Box<Integer> box = new Box<>(42);
        Box<Integer> box1 = box;
        Box<Short> box2 = new Box<>((short) 123);

        //Box<String> box3 = new Box<>("Hello Generics");



        Crate<Box<?>> crate = new Crate<>();
        crate.addBox(box);
        crate.addBox(box1);
        crate.addBox(box2);
        //crate.addBox(box3);

        System.out.println(crate);

        Map<Integer, List<Map<Integer, List<Map<String, ?>>>>> map = new HashMap<>();



    }
}
