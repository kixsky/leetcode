package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratePossibleNextMoves {


    public static void main(String[] args) {

        System.out.println(generatePossibleNextMoves("++++"));
    }
    public static List<String> generatePossibleNextMoves(String s) {

        char[] chars = s.toCharArray();

        List<String> list = new ArrayList<>();
        for (int i = 0;i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                char[] char1 = Arrays.copyOf(chars, chars.length);
                char1[i] = '-';
                char1[i + 1] = '-';
                list.add(new String(char1));
            }
        }
        return list;
    }
}
