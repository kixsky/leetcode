package com.company.string;

/**
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LengthOfLastWord {


    public static void main(String[] args) {


        System.out.println(lengthOfLastWord2("a"));
    }


    public static int lengthOfLastWord(String s) {
        if (s == null) return 0;
        int count = 0; //计数器
        boolean flag = false;//遇见空格置为true
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (flag && chars[i] != ' ') count = 0;

            if (chars[i] == ' ') {
                flag = true;
            } else {
                count++;
                flag = false;
            }
        }
        return count;
    }

    /**
     *
     * 从后往前搜索
     *
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        if (s == null) return 0;
        int count = 0; //计数器
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] != ' ') count++;
            if (chars[i] == ' ' && count > 0) return count;
        }
        return count;
    }
}
