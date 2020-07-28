package jianzhi.order;

public class _64_求和 {

    // 使用递归求和
     public int sumNums(int n) {
         if (n == 1) return 1;
         return n + sumNums(n - 1);
     }
}
