package scratchPad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fundamentals {

    private static void a(int a) {
        a++;
        b(a);
    }

    private static void b(int b) {
        b++;
    }

    public static void main(String[] args) {

        System.out.println(String.format("%04d", Integer.valueOf(9000)));

        StringBuilder sb = new StringBuilder("9000");
        sb.replace(3, 4, "1");
        System.out.println(sb.toString());
    }

}
