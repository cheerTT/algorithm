package test.xiaohongshu._0906;

import java.util.Scanner;

public class _01 {

    public static int[] subSort(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        if (arr.length < 2) return new int[] {-1, -1};

        int min = arr[i];
        int max = arr[j];

        int minLen = arr.length;
        while (i <= j) {
            if (i < arr.length - 1 && arr[i] <= arr[i + 1] && arr[i] <= max) {
                min = arr[i];
                i++;
            }
            if (j > 0 && arr[j] >= arr[j - 1] && arr[j] >= min) {
                max = arr[j];
                j--;
            }

            if (j - i + 1 < minLen) {
                minLen = j - i + 1;
            } else {
                break;
            }

        }


        if (i > j) return new int[] {-1, -1};
        else {
            while (i > 0 && arr[i] == arr[i - 1]) i--;
            while (j < arr.length && arr[j] == arr[j + 1]) j++;
            return new int[] {i, j};
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = subSort(_arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

/**
 *
 * 6
 * 6 5 4 3 2 1
 * 5
 * 6 5 3 2 1
 *
 * 6 5 3 2 1
 */
