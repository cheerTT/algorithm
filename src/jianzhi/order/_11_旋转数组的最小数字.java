package jianzhi.order;

public class _11_旋转数组的最小数字 {

    // 二分查找
    // 假定数组最右边的值为最小值
    public int minArray(int[] numbers) {

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;
            if (numbers[mid] < numbers[j])  {
                j = mid;
            } else if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else {
                j = j - 1;
            }
        }

        return numbers[i];
    }

}
