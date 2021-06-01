package scratchPad;

public class Fundamentals {

    private static void a(int a){
        a++;
        b(a);
    }

    private static void b(int b){
        b++;
    }

    public static void main(String[] args) {
        int x = 4;
        a(x);
        System.out.println(x);

    }

}
