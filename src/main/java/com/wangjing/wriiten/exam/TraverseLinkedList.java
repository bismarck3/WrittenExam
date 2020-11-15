/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.TraverseLinkedList
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * TraverseLinkedList
 *
 * @description 遍历链表：从尾到头反过来打印出每个结点的值。
 * @thinking 一递归：while（node.hashNext）取到最后一个元素
 * 二头插：重新构建链表，使用头插法
 * 三栈：经典先进后出
 * @author wangjing
 * @date 2020/11/15 16:54
 * @version v1.0.0
 */
public class TraverseLinkedList {

    static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

    }

    private static List<Integer> listByRecursion(Node<Integer> node) {
        List<Integer> traverseList = new ArrayList<>();
        if (node != null) {
            traverseList.addAll(listByRecursion(node.next));
            traverseList.add(node.item);
        }
        return traverseList;
    }

    private static List<Integer> rebuildLinkedList(Node<Integer> node) {
        Node<Integer> head = new Node<>(-1, null);
        while (node != null) {
            // 取出下一个节点
            Node<Integer> next = node.next;
            // head的next指向node的下个节点
            node.next = head.next;
            // 节点挂在到head的next
            head.next = node;
            // 循环下一个节点
            node = next;
        }
        List<Integer> traverseList = new ArrayList<>();
        node = head.next;
        while (node != null) {
            traverseList.add(node.item);
            node = node.next;
        }
        return traverseList;
    }


    public static void main(String[] args) {
        System.out.println(listByRecursion(init()));
    }

    private static Node<Integer> init() {
        Node<Integer> node4 = new Node<>(4, null);
        Node<Integer> node3= new Node<>(3, node4);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node = new Node<>(1, node2);
        return node;
    }
}
