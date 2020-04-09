package ru.rgordeev.module4;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int[] result = new int[0];
        for(int i = 0; i < a.length; i ++) {
            if (find(a[i], result)) continue;
            else result = copy(result, a[i]);
        }

        System.out.println(result.length);

    }

    private static int[] copy(int[] a, int k) {
        int[] result = new int[a.length + 1];
        if (a.length == 0) {
            result[0] = k;
            return result;
        }
        for (int i = 0; i < a.length; i ++)
            result[i] = a[i];
        result[result.length - 1] = k;
        return result;
    }

    private static boolean find(int key, int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int i = left + (right - left) / 2;
            if (key < a[i]) {
                right = i - 1;
            } else  if (key > a[i]) {
                left = i + 1;
            } else return true;
        }
        return false;
    }

}
