package com.just.learn.basic.tree.binary;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.Soundbank;
import javax.swing.tree.TreeNode;

/**
 * @description:二叉树
 * @author: Peng.Li
 * @create: 2020-05-06 10:24
 **/
public class BinaryTreeDemo {

    @Getter
    @Setter
    private static class Node {
        Node leftChild;

        Node rightChild;

        int data;

        Node(int data) {
            leftChild = null;
            rightChild = null;
            this.data = data;
        }
    }


    public Node createBinTree(int[] array) {
        List<Node> list = new LinkedList<>();

        //将每个数组的值依次转为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            list.add(new Node(array[nodeIndex]));
        }

        //对前 lastParentIndex -1 个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            //当前节点
            Node parent = list.get(parentIndex);
            //左孩子
            Node left = list.get(parentIndex * 2 + 1);
            parent.leftChild = left;

            //右孩子
            Node right = list.get(parentIndex * 2 + 2);
            parent.rightChild = right;
        }

        //处理最后一个父节点
        int lastParentIndex = array.length / 2 - 1;
        //左孩子
        Node lastParent = list.get(lastParentIndex);
        Node left = list.get(lastParentIndex * 2 + 1);
        lastParent.leftChild = left;

        //右孩子，奇树才有右孩子
        if (array.length % 2 == 1) {
            Node right = list.get(lastParentIndex * 2 + 2);
            lastParent.rightChild = right;
        }
        //对象引用
        return list.get(0);
    }

    /**
     * 前序遍历：先访问根节点-再前序遍历左子树，最后前序遍历右子树
     * @param node
     */
    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历：先中序遍历左子树,再访问根节点，再中序遍历右子树
     * @param node
     */
    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历：先后序遍历左子树，再后续遍历右子树，最后访问根节点
     * @param node
     */
    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data + " ");
    }



    public static void main(String[] args) {
        int[] array = {1, 3, 4, 0, 9, 7, 2, 8};
        BinaryTreeDemo binaryTreeDemo = new BinaryTreeDemo();
        Node nodes = binaryTreeDemo.createBinTree(array);

        //前序
        System.out.print("先-- ");
        binaryTreeDemo.preOrderTraversal(nodes);
        System.out.println();


        //中序
        System.out.print("中-- ");
        binaryTreeDemo.inOrderTraversal(nodes);
        System.out.println();

        //后序
        System.out.print("后-- ");
        binaryTreeDemo.postOrderTraversal(nodes);
        System.out.println();

    }
}
