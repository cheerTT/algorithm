package test._360._0911;

import sun.reflect.generics.tree.Tree;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            boolean res = isVliad(sc.nextLine());
            if (res) System.out.println("Ok");
            else System.out.println("Irregular password");
        }
    }

    private static boolean isVliad(String str) {

        if (str.length() < 8) return false;

        boolean bigNum = false;
        boolean smallNum = false;
        boolean specChar = false;
        boolean num = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') bigNum = true;
            else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') num = true;
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') smallNum = true;
            else specChar = true;
        }

        return bigNum && smallNum && specChar && num;
    }
}
