package ru.rgordeev.module4.class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Integer> a = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++)
            a.add(in.nextInt());

        int count = 0;
        int index = findSequence(a);
        while (index > 0) {
            int start = findMostLeft(a, index);
            int end = findMostRight(a, index);
            count = count + (end - start + 1);
            a = removeThreeAndMore(a, start, end);
            index = findSequence(a);
        }
        System.out.println(count);
    }

    public static int findSequence(List<Integer> a) {
        int size = 1;
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i) == a.get(i + 1)) {
                size = size + 1;
                if (size >= 3) return i;
            } else size = 1;

        }
        return -1;
    }

    public static int findMostLeft(List<Integer> a, int index) {
        if (index == 0) return index;
        while (index > 0 && a.get(index - 1) == a.get(index))
            index = index - 1;
        return index;
    }

    public static int findMostRight(List<Integer> a, int index) {
        if (index == a.size() - 1) return index;
        while (index < a.size() - 1 && a.get(index) == a.get(index + 1))
            index = index + 1;
        return index;
    }

    public static List<Integer> removeThreeAndMore(List<Integer> a, int start, int end) {
        if (a == null || a.size() == 0) return a;
        List<Integer> b = a.subList(0, start);
        List<Integer> c = a.subList(end + 1, a.size());
        b.addAll(c);
        return b;
    }
}
