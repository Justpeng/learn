package test;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int v;

    private Node next;

    private Node(int v){
        this.v =v;
        next = null;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node node2 = reverseNode(node);
        while (node2 != null) {
            System.out.println(node2.v);
            node2 = node2.next;
        }

    }

    public static Node reverseNode(Node root){
        if (root == null || root.next == null) {
            return root;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.v);
        while (root.next != null) {
            list.add(root.next.v);
            root =root.next;
        }

        Node node2 = new Node(list.get(list.size() - 1));
        Node root2 = node2;
        for (int i = list.size() - 2; i >= 0; i--) {
            node2.next = new Node(list.get(i));
            node2 = node2.next;
        }
        return root2;
    }

    public static Node reverse2(Node head) {
        Node prev = null; Node curr= head;
        while (curr != null) {
            //暂存
            Node temp = curr.next;
            //修改next指针引用
            curr.next = prev;
            prev = curr;
            //curr访问下一节点
            curr  = temp;
        }
        return prev;
    }
}
