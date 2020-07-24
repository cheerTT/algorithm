package jianzhi.order;

public class _58_02_左旋转字符串 {

    public String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0, n);
    }
}
