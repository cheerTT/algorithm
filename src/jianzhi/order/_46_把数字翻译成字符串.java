package jianzhi.order;

public class _46_把数字翻译成字符串 {

    public int translateNum(int num) {

        String str = String.valueOf(num);

        int pre = 1;
        int cur = 1;

        for (int i = 2; i < str.length(); i++) {
            String s = str.substring(i - 2, i);
            int flag = (s.compareTo("10") >= 0 && s.compareTo("25") <= 0) ? pre + cur : cur;
            pre = cur;
            cur = flag;
        }

        return cur;
    }
}
