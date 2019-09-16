package com.company.linkedlist;

public class MyLinkedList {

    private ListNode head;

    private ListNode tail;

    private int size = 0;

    //构造方法
    public MyLinkedList() {

    }

    //返回索引下的值
    public int get(int index) {
        ListNode h = head;
        int count = 0;
        while(h != null) {
            h = h.next;
            if (index == count) return h.val;
            count++;
        }
        return -1;
    }

    //在头节点插入
    public void addAtHead(int val) {

        if (head == null) {
            //空
            tail = head = new ListNode(val);
            size++;
            return;
        }
        ListNode h = head;
        head = new ListNode(val);
        head.next = h;
        size++;
    }

    //尾节点插入
    public void addAtTail(int val) {
        if (tail == null) {
            //空
            tail = head = new ListNode(val);
            size++;
            return;
        }
        ListNode temp = tail;
        tail = new ListNode(val);
        tail.next = temp;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        if (index > size) return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (head == null) {
            //链表为空
            addAtHead(val);
            return;
        }
        int count = 0;
        ListNode h = head;
        while(h.next != null) {
            if (count == index) break;
            h = h.next;
            count++;
        }

        if (h == tail) {
            addAtTail(val);
            return;
        }

        //找h的前驱节点
        ListNode h1 = head;
        while(h1.next != h) {
            h1 = h1.next;
        }

        h1 = new ListNode(val);
        h1.next = h;
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode h = index(index);
        if (h == null) {
            return;
        }

        if (h == tail && h == head) {
            //链表中只有一个节点
            head = null;
            tail = null;
            size--;
            return;
        }

        if (h == head) {
            head = head.next;
            size--;
            return;
        }

        ListNode temp = front(h);
        temp.next = h.next;
        size--;
    }


    private ListNode index(int index) {
        if (index < 0 || index >= size) return null;
        ListNode h = head;
        int count = 0;
        while(h.next != null) {
            if (count == index) return h;
            h = h.next;
            count++;
        }
        return null;
    }

    /**
     *
     * 找到h节点的前驱节点
     * @param head
     * @param h
     * @return
     */
    private ListNode front(ListNode h) {
        if (head == h) return null;
        ListNode temp = head;
        while(temp != null && temp.next != h) {
            temp = temp.next;
        }
        return temp;
    }


    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}
