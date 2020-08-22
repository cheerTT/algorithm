package test.yuanfudao._0822;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int mark = 0;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();

            if (i == mark) {
                list1.add(nums[i]);
                mark = mark * 2 + i;
            }

            if (i == mark - 1) {
                list2.add(nums[i]);
            }
        }

        mark = (mark - 1) / 2;

        for (int i = mark + 1; i < n; i++) {
            list1.add(nums[i]);
        }

        int diff = n - mark;
        int last = (diff - 1) / 2 + 1;
        int len = (mark - 1) / 2 + 1;
        int start = (mark - 1) / 2 + last;

        for (int j = 0; j < len - last; j++) {
            list1.add(nums[j + start]);
        }

        for (int i = list2.size() - 2; i >= 1; i--) {
            list1.add(list2.get(2));
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i));
            if (i != list1.size() - 1) {
                System.out.println(list2.get(i));
            }
        }
        System.out.println();



    }
}
