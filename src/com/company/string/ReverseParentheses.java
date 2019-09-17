package com.company.string;

import java.util.Stack;

public class ReverseParentheses {

  public static void main(String[] args) {


    System.out.println(reverseParentheses("(u(love)i)"));
  }


  public static String reverseParentheses(String s) {

    Stack<Integer> left = new Stack<>();
    Stack<Integer> right = new Stack<>();

    char[] array = s.toCharArray();

    int i = 0;
    int j = array.length - 1;

    while(i < j) {
      if (array[i] == '(') left.push(i);
      if (array[j] == ')') right.push(j);
      i++;
      j--;
    }

    StringBuilder sb = new StringBuilder();
    for (char a: array) {
      if (a == '(') {

      } else if (a == ')') {

      }
    }
    return null;
  }
}
