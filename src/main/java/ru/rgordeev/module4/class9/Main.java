package ru.rgordeev.module4.class9;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        int a = 10;
//        System.out.println(f(a));
/*
        n! = n * (n - 1) * ... 1 = n * (n- 1)!

        f(10)
        sum(square(10), square(10))
        sum(10 * 10, 10 / 0)
        sum(100, 100)
        if (100 > 0) 100 else 100 + 100
        100 + 100
        200

        f(10)
        sum(square(10), square(10))
        sum(10 * 10, 10 / 0)
        if (10 * 10) > 0 100 else 10 * 10 + 10 / 10
        100 + 100
        200

 */
//        System.out.println(fact(5));
//        System.out.println(fact1(5));


//        System.out.println(fib(6));
//        System.out.println(fib1(6));

//        System.out.println(change(5));
        System.out.println(change(5));
    }

    public static long fact(long n) {
        if (n == 1) return 1;
        else return n * fact(n - 1);
    }

/*
    fact(6)
    5 * fact(4)
    5 * 4 * fact(3)
    5 * 4 * 3 * fact(2)
    5 * 4 * 3 * 2 * fact(1)
    5 * 4 * 3 * 2 * 1
    5 * 4 * 3 * 2
    5 * 4 * 6
    5 * 24
    5 * 24
    120
 */
    /*
    5 = 1 * 2 * 3 * 4 * 5
    прозведение = счетчик * произведение
    счетчик = счетчик + 1
     */

    /*

    fact1(5)
    factiter(1, 1, 5);
    factiter(1, 2, 5);
    factiter(2, 3, 5);
    factiter(6, 4, 5);
    factiter(24, 5, 5);
    factiter(120, 6, 5);
    120
     */

    public static long fact1(long n) {
        return factiter(1, 1, n);
    }

    public static long factiter(long prod, long counter, long n) {
        if (counter > n) return prod;
        else return factiter(counter * prod, counter + 1, n);
    }



    public static int f(int a) {
        return sum(square(a), square(a));
    }

    public static int sum(int a, int b) {
        if (a > 0) return a;
        return a + b;
    }

    public static int square(int a) {
        return a * a;
    }

    /*

             0, n = 0
    fib(n) = 1, n = 1
             fib(n - 1) + fib(n - 2)

     */

    public static long fib(long n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fib(n - 1) + fib(n - 2);
    }

    /*

                                                       fib(5)
                                             fib(4)                        fib(3)
                                        fib(3)      fib(2)          fib(2)        fib(1)
                                    fib(2) fib(1)  fib(1) fib(0)  fib(1) fib(0)
                                fib(1) fib(0)
     */

    public static long fib1(long n) {
        return fibiter(1, 0, n);
    }

    public static long fibiter(long sum, long presum, long counter) {
        if (counter == 0) return presum;
        else return fibiter(sum + presum, sum, counter - 1);
    }


/*

    100

    50
    25
    10
    5
    ...

    100 - 50
    25
    10
    5
    3
    2
    1

    50 25 10 5 3 2 1
    7  6  5  4 3 2 1
    Число способов разменять сумму S при момощи n типов монет =

*/
    public static Map<Long, Long> coins = new HashMap<>();

    static {
        coins.put(1L,1L);
        coins.put(2L,2L);
        coins.put(3L,3L);
        coins.put(4L,5L);
//        coins.put(5L,10L);
//        coins.put(6L,25L);
//        coins.put(7L,50L);
    }

    public static long change(long amount) {
        return changeiter(amount, 4L);
    }


    public static long changeiter(long amount, long coins_count) {
        if (amount == 0) return 1;
        else if ((amount < 0) || (coins_count == 0)) return 0;
        else return changeiter(amount, coins_count - 1) + changeiter(amount - coins.get(coins_count), coins_count);
    }



}
