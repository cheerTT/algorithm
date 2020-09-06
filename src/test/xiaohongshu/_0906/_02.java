package test.xiaohongshu._0906;

import java.util.Arrays;
import java.util.Scanner;

public class _02 {

    static int findMin(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        int[] nums = new int[m * n];

        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[k++] = arr[i][j];
            }
        }

        Arrays.sort(nums);

        if (nums[0] > 1) return 1;

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                res = nums[i];
            } else {
                break;
            }
        }

        return res + 1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_rows = 0;
        int _arr_cols = 0;
        _arr_rows = Integer.parseInt(in.nextLine().trim());
        _arr_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _arr = new int[_arr_rows][_arr_cols];
        for(int _arr_i=0; _arr_i<_arr_rows; _arr_i++) {
            for(int _arr_j=0; _arr_j<_arr_cols; _arr_j++) {
                _arr[_arr_i][_arr_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        res = findMin(_arr);
        System.out.println(String.valueOf(res));

    }
}
