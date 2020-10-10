package lagou;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class S01 {

    /**
     * 翻转字符串
     * @param s
     * @return
     */
    public static String reverseChar(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            swap(chars, i, j);
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public static void swap(char[] chars, int i, int j) {
        char a = chars[i];
        chars[i] = chars[j];
        chars[j] = a;
    }

    /**
     * 是否异位词
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 1) {
            return s.equals(t);
        }
        int[] char_array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_array[s.charAt(i) - 'a'] ++;
            char_array[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < char_array.length; i++) {
            if (char_array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 24. 两两交换链表中的节点给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        //交换
        firstNode.next = swapPairs(secondNode.next);
        //第二个结点指向第一个结点
        secondNode.next = firstNode;
        //第二个结点成了 头节点
        return secondNode;
    }


    /**
     * 第 25 题：给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
     * k是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     */
    public static ListNode swapPairs(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            //按装回原链表
            pre.next = hair;
            tail.next = nex;
            pre = tail;
            hair = tail.next;
        }
        return hair.next;
    }

    private static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }



    public static class ListNode {
        int val;

        ListNode next;
        ListNode pre;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static final Map<Character, Character> characterMap = new HashMap<>();
    static {
        characterMap.put('{', '}');
        characterMap.put('(', ')');
        characterMap.put('[', ']');
        characterMap.put('?', '?');
    }

    /**
     * 第20题，有效的括号
     */
    public static boolean isValid(String str) {
        //奇数
        if (str.length() % 2 == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        stack.add('?');
        for (Character c : str.toCharArray()) {
            if (characterMap.containsKey(c)) {
                stack.add(c);
            } else {
                //后进先出
                Character character = stack.removeLast();
                if (characterMap.get(character) != c) {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }





    public static void main(String[] args) {
        System.out.println(reverseChar("beijing"));
        // 6226 7302 0092 4287
        System.out.println(isAnagram("beijing","tianjin"));
    }
}
