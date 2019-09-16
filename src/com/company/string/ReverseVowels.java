package com.company.string;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowels {


    public static void main(String[] args) {

        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {

        if (s == null) return null;

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int i = 0;
        int j = chars.length - 1;
        while(i <= j) {
            if (set.contains(chars[i])) {
                if (set.contains(chars[j])) {
                    //交换
                    char a = chars[i];
                    chars[i] = chars[j];
                    chars[j] = a;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return new String(chars);
    }
}
