package test.suning._0909;

public abstract class _01 {

    _01(int i) {
        System.out.println();
    }


    public static void main(String[] args) {

        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }

}

interface A {

    default void aaa() {}
}
