package ru.rgordeev.module4.class2;

import java.util.*;


public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        final List<Character> brackets = new ArrayList<Character>() {{
            add('(');
            add(')');
            add('[');
            add(']');
            add('{');
            add('}');
        }};

        final Map<Character, Character> openByClose = new HashMap<>();
        openByClose.put(')', '(');
        openByClose.put(']', '[');
        openByClose.put('}', '{');


        Stack<Character> s = new Stack<Character>();
        boolean wrong = false;
        for (int i = 0; i < text.length(); i++) {
            if (wrong) break;
            char next = text.charAt(i);
            if (brackets.contains(next) && brackets.indexOf(next) % 2 == 0)
                s.push(next);
            else if (brackets.contains(next) && brackets.indexOf(next) % 2 == 1) {
                if (s.empty() || (s.peek() != openByClose.get(next)))
                    wrong = true;
                else s.pop();
            }
        }
        if (!s.empty()) wrong = true;
        if (wrong) System.out.println("no");
        else System.out.println("yes");
    }
}
