/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.BasicLinkedList
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;
/**
 * BasicLinkedList
 *
 * @description 链表基础
 * @author wangjing
 * @date 2020/11/15 17:26
 * @version v1.0.0
 */
public class BasicLinkedList implements Linked{

    class Node{

        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    // 链表只有一个head，不存元素
    private Node head;


    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            // 头插，新元素作为head
            node.next = head;
            // 更新head
            head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            // 找到尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            // 插入尾巴
            cur.next = node;
            }
    }

    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchNode(index);
        if (cur == null) {
            node.next = this.head;
            this.head = node;
        } else {
            node.next = cur.next;
            cur.next = node;
        }
        return false;
    }

    private Node searchNode(int index) {
        int count = 0;
        Node cur = this.head;
        while (cur.next != null && count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    @Override
    public boolean contain(int key) {
        while (head != null) {
            if (head.data == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node pre = searchPreNode(key);
        if (pre == null) {
            throw new UnsupportedOperationException("没有key的前驱节点");
        }
        if (pre == this.head && pre.data == key) {
            int oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        return 0;
    }

    private Node searchPreNode(int key) {
        Node cur = this.head;
        if (cur.data == key) {
            return null;
        }
        while (cur.next != null ) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
            if (this.head.data == key) {
                this.head = this.head.next;
            }
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
           cur = cur.next;
           count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    @Override
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }
}


interface Linked{

    void addFirst(int data);

    void addLast(int data);

    boolean addIndex(int index, int data);

    boolean contain(int key);

    int remove(int key);

    void removeAllKey(int key);

    int getLength();

    void display();

    void clear();
}
