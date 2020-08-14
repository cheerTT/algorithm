package alibaba.str;

public class _19_正则表达式匹配 {

    // 递归
    // 下一个字符是 * 的时候
    //      当前字符不匹配
    // 下一个字符不是 * 的时候
    // // 当前匹配
    // // 当前不匹配
    public boolean isMatch(String s, String p) {

        return help(s, p, 0, 0);
    }

    private boolean help(String s, String p, int i, int j) {

        // 顺利走到了尽头
        if (i == s.length() && j == p.length()) return true;

        // 模式串走到尽头，另一个还没有结束
        if (i != s.length() && j == p.length()) return false;

        // 下一个字符是 * 的时候
        if ((j + 1) < p.length() - 1 && p.charAt(j + 1) == '*') {
            // 当前匹配
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return help(s, p, i + 1, j) ||  // 当前动，下一个不动，代表 弃权
                        help(s, p, i, j + 2) || // 当前不动，下一个动，代表 0个
                        help(s, p, i + 1, j + 2); // 代表 1 个
            } else { // 不匹配
                return help(s, p, i + 1, j + 2);
            }
        } else { // 下一个字符不是 * 的时候
            // 当前匹配
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return help(s, p, i + 1, j + 2);
            } else {
                return false;
            }
        }
    }
}
