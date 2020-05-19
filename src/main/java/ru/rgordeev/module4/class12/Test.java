package ru.rgordeev.module4.class12;

import java.util.*;

public  class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeMap<String, TreeMap<String, Integer>> objects = new TreeMap<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] objs = line.split(" ");
            TreeMap<String, Integer> good = new TreeMap<>();
            good.put(objs[1], Integer.valueOf(objs[2]));
            objects.put(objs[0], good);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry: objects.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> g: entry.getValue().entrySet()) {
                System.out.println(g.getKey() + " " + g.getValue());
            }
        }
    }
}
