package test.xinglang._0913;

import sun.reflect.generics.tree.Tree;

import javax.xml.transform.SourceLocator;
import java.security.PrivateKey;
import java.util.Scanner;

public class _02 {

    private boolean flag = false;

    public void quickSort(char[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickDetail(arr, 0, arr.length-1);
    }

    public void quickDetail(char[] arr, int l, int r) {

        // 这个条件一定需要最新进行判断
        if (l > r) {
            return;
        }

        int tmp = arr[l];  // 枢轴存放的位置
        int i = l;
        int j = r;


        while(i < j) {
            while (arr[j] >= tmp && i < j) {
                if (arr[j] == tmp) flag = true;
                j--;
            }
            while (arr[i] <= tmp && i < j) {
                if (arr[i] == tmp) flag = true;
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, l);
        quickDetail(arr, l, i-1);
        quickDetail(arr, i+1, r);
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char[] chars = str.toCharArray();

        _02 solution = new _02();
        solution.quickSort(chars);

        System.out.println(!solution.flag);
    }
}
