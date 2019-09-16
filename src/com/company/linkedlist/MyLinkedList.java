package com.company.linkedlist;

public class MyLinkedList {


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }


    private ListNode head;

    private ListNode tail;

    private int size = 0;

    //构造方法
    public MyLinkedList() {

    }

    //返回索引下的值
    public int get(int index) {
        ListNode h = index(index);
        if (h != null) return h.val;
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
        tail.next = new ListNode(val);
        tail = tail.next;
        size++;
    }

    public void addAtIndex(int index, int val) {
        //index < 0
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

        ListNode h = index(index);
        if (h == null) return;

        if (h == head) {
            addAtHead(val);
            return;
        }

        //找h的前驱节点
        ListNode h1 = front(h);
        h1.next = new ListNode(val);
        h1.next.next = h;
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

        //删除头结点
        if (h == head) {
            head = head.next;
            size--;
            return;
        }

        //删除尾节点
        if (h == tail) {
            ListNode f = front(h);
            f.next = null;
            size--;
            tail = f;
            return;
        }

        //处理其他节点
        ListNode temp = front(h);
        temp.next = h.next;
        size--;
    }


    private ListNode index(int index) {
        if (index < 0 || index >= size) return null;
        ListNode h = head;
        int count = 0;
        while(h != null) {
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
