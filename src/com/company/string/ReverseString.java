package com.company.string;

public class ReverseString {

    public void reverseString(char[] s) {
        char a = s[0];
        int i = 0;
        int j = s.length - 1;
        while(i <= j) {
            a = s[i];
            s[i] = s[j];
            s[j] = a;
            i++;
            j--;
        }
    }
}
