package jianzhi.order;

public class _58_01_翻转单词顺序 {

    public String reverseWords(String s) {

        String[] strs = s.trim().split(" ");

        int i = 0;
        int j = strs.length - 1;

        while (i <= j) {
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j--] = tmp;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
