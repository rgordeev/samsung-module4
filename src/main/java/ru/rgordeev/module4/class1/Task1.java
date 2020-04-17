package ru.rgordeev.module4.class1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        int[] b = new int[k];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            b[i] = in.nextInt();
        }

        for (int i = 0; i < k; i++)
            System.out.println(find(b[i], a));
    }

    private static String find(int key, int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int i = left + (right - left) / 2;
            if (key < a[i]) {
                right = i - 1;
            } else  if (key > a[i]) {
                left = i + 1;
            } else return "YES";
        }
        return "NO";
    }

}
