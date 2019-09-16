package com.company;

import java.util.ArrayList;
import java.util.List;

public class MaxNumberOfBalloons {

  public static void main(String[] args) {

    System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
  }


  public static int maxNumberOfBalloons(String text) {
    char[] balloon = new char[]{'b', 'a', 'l','l','o','o','n'};
    char[] array = text.toCharArray();

    //读到list里面去
    List<Character> list = new ArrayList<>();
    for (char a: array) {
      list.add(a);
    }

    int count = 0;
    while(true) {
      for (char a: balloon) {
        boolean flag = false;
        Character del = null;
        for (Character b: list) {
          if (a == b) {
            flag = true;
            del = b;
            break;
          }
        }

        if (flag) {
          list.remove(del);
        } else {
          return count;
        }
      }

      count++;
    }
  }
}
