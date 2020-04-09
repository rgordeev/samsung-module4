package ru.rgordeev.module4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int k = in.nextInt();
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = in.nextInt();
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++)
            result[i] = 0;

        for (int i = 0; i < k; i++) {
            result[i] = freq(b[i], a);
        }

        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

    private static int freq(int key, int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i ++) {
            if (key == a[i]) result = result + 1;
        }
        return result;
    }

}
