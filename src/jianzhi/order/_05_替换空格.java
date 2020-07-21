package jianzhi.order;

public class _05_替换空格 {

    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }
}
