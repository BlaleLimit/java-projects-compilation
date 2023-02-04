package datastruct;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTesting {
    public static void main(String[] args) {
        // check if item is in defined list
        StringList sl = new StringList("Kirby");
        sl.getResult();

        // rounds up a BigDecimal number
        Rounding r = new Rounding(RoundingMode.UP, new BigDecimal("2.71828"));
        r.getResult();

        // calculates the factorial of a given number
        Factorial f = new Factorial(5);
        f.getResult();

        // reverses the letters in a string with first letter as capital
        ReverseString rs = new ReverseString("Reverse This");
        rs.getResult();
    }
}

class StringList {
    String s;
    ArrayList<String> al = new ArrayList<>(Arrays.asList("Kirby", "Iron Man", "Thanos", "Spiderman", "Pizza Mozarella"));
    public StringList(String s) {
        this.s = s;
    }
    private boolean inList(String s, ArrayList<String> al) {
        return al.contains(s);
    }
    public void getResult() {
        System.out.println(s + ": " + inList(s, al));
    }
}

class Rounding {
    RoundingMode rm;
    BigDecimal bd;
    public Rounding(RoundingMode rm, BigDecimal bd) {
        this.rm = rm;
        this.bd = bd;
    }
    public void getResult() {
        System.out.println(bd.setScale(8, rm));
    }
}

class Factorial {
    int n;
    public Factorial(int n) {
        this.n = n;
    }
    private int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public void getResult() {
        System.out.println(factorial(n));
    }
}

class ReverseString {
    String s;
    StringBuilder sb = new StringBuilder();
    public ReverseString(String s) {
        this.s = s;
    }
    private String reverse(String s) {
        sb.append(s.toLowerCase());
        String temp = sb.reverse().substring(0, 1).toUpperCase();
        return temp + sb.substring(1);
    }
    public void getResult() {
        System.out.println(reverse(s));
    }
}




