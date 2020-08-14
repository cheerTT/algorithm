package jianzhi.order;

public class _19_正则表达式的匹配 {

     public boolean isMatch(String s, String p) {

        return help(s, p, 0, 0);
     }

     public boolean help(String s, String p, int i, int j) {

         // 递归终止条件 i,j 均走到了尽头
         if (i == s.length() && j == p.length()) return true;

         // 异常情况，i 未走到尽头，j 走到了尽头
         if ( i != s.length() && j == p.length()) return false;

         // 当 p 的下一个字符是 * 的时候
         if (j < p.length() && p.charAt(j + 1) == '*') {
             // //当前匹配
            if (i < s.length() && s.charAt(i) == p.charAt(j) || p.charAt(i) == '.') {
                // // // 字符串和模式串都向后移动
                // // // 字符串不动，模式串向后移动
                // // // 字符串向后移动，模式串不动
                return help(s, p, i + 1,j + 2)
                        || help(s, p, i, j + 2)
                        || help(s, p, i + 1, j);
            } else { // // 当前不匹配
                // // // 字符串不动，模式串向后移动
                return help(s, p, i, j + 2);
            }
         }

         // 当 p 的下一个字符不是 * 的时候
         // // 当前匹配
         if (i < s.length() && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
             // // // 字符串和模式串都向后移动
             return help(s, p, i + 1, j + 1);
         }

         // // 当前不匹配
         // // // 返回 false
         return false;
     }

    public static void main(String[] args) {

         _19_正则表达式的匹配 solution = new _19_正则表达式的匹配();
        boolean match1 = solution.isMatch("aa", "a");
        System.out.println(match1);

        boolean match2 = solution.isMatch("aa", "a*");
        System.out.println(match2);
    }
}
