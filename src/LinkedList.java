package com.qianggao;

public class LinkedList<T> {
  private int currentSize = 0;
  private Node<T> head;
  private Node<T> tail;

  public LinkedList() {
    Node<T> head = tail = null;
  }

  // adding First
  public void addFirst(T obj) {
    Node<T> node = new Node<>(obj);
    node.next = head;
    head = node;
    currentSize++;
  }

  // adding last
  public void addLast(T obj) {
    Node<T> node = new Node<>(obj);

    if (head == null) {
      head = tail = node;
      currentSize++;
      return;
    }
    tail.next = node;
    tail = node;
    currentSize++;
  }

  // remove first
  public T removeFirst() {
    if (head == null) {
      return null;
    }
    T tmp = head.data;
    if (head == tail) {
      head = tail = null;
    } else {
      head = head.next;
    }
    currentSize--;
    return tmp;
  }

  // remove last
  public T removeLast() {
    if (head == null) {
      return null;
    }
    if (head == tail) {
      return removeFirst();
    }
    Node<T> prev = null;
    Node<T> current = head;
    while (current != tail) {
      prev = current;
      current = current.next;
    }
    prev.next = null;
    tail = prev;
    currentSize--;
    return current.data;
  }

  // remove a element
  public T remove(T obj) {
    Node<T> prev = null;
    Node<T> current = head;
    while (current != null) {
      if (((Comparable<T>) current.data).compareTo(obj) == 0) {
        if (current == head) {
          return removeLast();
        }
        if (current == tail) {
          return removeLast();
        }
        currentSize--;
        prev.next = current.next;
        return current.data;
      }
      prev = current;
      current = current.next;
    }
    return null;
  }

  // contains
  public boolean contains(T obj) {
    Node<T> current = head;
    if (head == null) {
      return false;
    }
    while (current != null) {
      if (((Comparable<T>) current.data).compareTo(obj) == 0) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  public T peekFirst() {
    if (head == null) {
      return null;
    }
    return head.data;
  }

  public T peekLast() {
    if (tail == null) {
      return null;
    }
    return tail.data;
  }

  public int size(){
    return currentSize;
  }


  static class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T obj) {
      data = obj;
      next = null;
    }
  }

}