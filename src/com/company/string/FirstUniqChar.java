package com.company.string;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *  
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {

        if (s == null) return -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = false;
            for (int j = 0;j < chars.length; j++) {
                if (i == j) continue;
                if (chars[i] == chars[j]) flag = true;
                if (flag) break;
            }
            if (!flag) return i;
        }
        return -1;
    }
}
