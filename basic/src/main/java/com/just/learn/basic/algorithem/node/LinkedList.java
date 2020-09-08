package com.just.learn.basic.algorithem.node;

public class LinkedList {

    private Node head;

    private Node last;

    private int size;


    public Node remove(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        Node removeNode = null;
        if (index == 0) {
            //删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size) {
            removeNode = last;
            Node prevNode = get(index - 1);
            prevNode.next = null;
            last = prevNode;
        } else {
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            return;
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            //空链表
            head = insertNode;
            last = insertNode;
        }else if (index == 0) {
            //插入头部
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            //插入对尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            //插入中间
            Node preNode = get(index - 1);
            if (preNode == null) {
                return;
            }
            insertNode.next = preNode.next;
            preNode.next  = insertNode;
        }
        size++;
    }

    /**
     * 查找元素
     * @param index
     * @return
     */
    private Node get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = head.next;
        }
        return temp;
    }





    public static class Node {
        Node next;

        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void outPut() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = head.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 0);
        linkedList.insert(7, 1);
        linkedList.insert(3, 2);
        linkedList.insert(4, 3);
        linkedList.insert(6, 1);
        linkedList.outPut();
    }
}
