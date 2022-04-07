package com.qianggao;

public class LinkedListTester {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    int n= 10;
    for(int i = 0;i<n;i++){
      list.addFirst(i);
    }
    System.out.println(list.size()==10);
  }
}
