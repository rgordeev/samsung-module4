package ru.rgordeev.module4.class1;

import java.util.Scanner;

public class Task2 {

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

        for (int i = 0; i < k; i++) {
            int[] result = find(b[i], a);
            if (result[0] == result[1] && result[0] == 0)
                System.out.println(0);
            else
                System.out.println(result[0] + " " + result[1]);
        }
    }

    private static int[] find(int key, int[] a) {
        int[] result = new int[2];
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int i = left + (right - left) / 2;
            if (key < a[i]) {
                right = i - 1;
            } else  if (key > a[i]) {
                left = i + 1;
            } else {
                int mostLeft    = findMostLeft(key, i, a);
                int mostRigth   = findMostRight(key, i, a);
                result[0] = mostLeft    + 1;
                result[1] = mostRigth   + 1;
                return result;
            }
        }
        return new int[]{0, 0};
    }

    private static int findMostLeft(int key, int i, int[] a) {
        int j = i;
        while (j >= 0 && a[j] == key) {
            j = j - 1;
        }
        return j + 1;

    }

    private static int findMostRight(int key, int i, int[] a) {
        int j = i;
        while (j <= a.length - 1 && a[j] == key) {
            j = j + 1;
        }
        return j - 1;
    }
}
