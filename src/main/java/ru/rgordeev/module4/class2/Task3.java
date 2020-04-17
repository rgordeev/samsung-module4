package ru.rgordeev.module4.class2;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> symbols = new ArrayList<>();
        String line = in.nextLine();
        symbols.addAll(Arrays.asList(line.split(" ")));
        Stack<Integer> operands = new Stack<>();
        List<String> operators = new ArrayList<String>() {{
            add("*");
            add("+");
            add("-");
        }};
        for (String next: symbols) {
            if (operators.contains(next)) {
                Integer b = operands.pop();
                Integer a = operands.pop();
                operands.push(calc(a, b, next));
            } else {
                operands.push(Integer.valueOf(next));
            }
        }
        System.out.println(operands.pop());
    }

    public static Integer calc(Integer a, Integer b, String operator) {
        if (operator.equals("+"))
            return a + b;
        else if (operator.equals("-"))
            return a - b;
        else if (operator.equals("*"))
            return a * b;
        return 0;
    }
}
