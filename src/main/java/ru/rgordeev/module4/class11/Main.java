package ru.rgordeev.module4.class11;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        MySet set = new MySet();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("#")) break;
            String command = line.split(" ")[0];
            String value = line.split(" ")[1];
            if (command.equals("+")) set.put(value);
            if (command.equals("?")) System.out.println(set.contains(value) ? "YES" : "NO");
        }

    }

/*
  0      1     2      3      4      5      6      7      8      9
[true, false, true, false, false, false, false, false, false, false]

0 1 2 3 4 5 6 7 8 9

+ 1
+ 2
+ 7
? 3

        0      1     2      3      4      5      6      7      8      9
a = [false, false, false, false, false, false, false, false, false, false]

hashCode(1) = 1
a[1] = true

        0      1     2      3      4      5      6      7      8      9
a = [false, true, false, false, false, false, false, false, false, false]

hashCode(2) = 2
a[2] = true

        0      1     2      3      4      5      6      7      8      9
a = [false, true, true, false, false, false, false, false, false, false]


hashCode(7) = 7
a[7] = true

        0      1     2      3      4      5      6      7      8      9
a = [false, true, true, false, false, false, false, true, false, false]
*/

    static class MySet {
        boolean[] b = new boolean[1000000];

        public MySet() {
        }

        public void put(String s) {
            int h = s.hashCode();
            h = h & (1000000 - 1);
            b[h] = true;
        }

        public boolean contains(String s) {
            int h = s.hashCode();
            h = h & (1000000 - 1);
            return b[h];
        }

    }

}
