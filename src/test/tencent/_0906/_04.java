package test.tencent._0906;

import java.util.Arrays;
import java.util.Scanner;

public class _04 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] tmp = new int[n - 1];

        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                tmp[k++] = nums[j];

            }
            Arrays.sort(tmp);
            System.out.println(tmp[(n - 1) / 2]);
        }


    }
}

/*
*
* 6
* 1 2 3 4 5 6
* 4
* 4
* 4
* 3
* 3
* 3
*
*
* */