/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.FindItsLnr
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;
/**
 * FindItsLnr
 *
 * @description 查找节点的中序遍历下个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @thingking
 * 如果该节点有右子树，那么下个中序遍历的节点是右子树的最左节点
 * 如果该节点没有右子树，那么中序遍历的节点是根节点
 * @author wangjing
 * @date 2020/11/30 21:58
 * @version v1.0.0
 */
public class FindItsLnr {

    public static TreeLinkedNode getNextLnrNode(TreeLinkedNode treeLinkedNode) {
        while(true) {
            // 如果有右子树，取右子树的最左节点
            if (treeLinkedNode.right != null) {
                TreeLinkedNode currentNode = treeLinkedNode.right;
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                return currentNode;
            }
            // 如果没有右子树，取根节点
            if (treeLinkedNode.next != null) {
                TreeLinkedNode currentNode = treeLinkedNode.next;
                if (currentNode.left == treeLinkedNode) {
                    return currentNode;
                }
            }
        }

    }

    class TreeLinkedNode {
        private int val;
        private TreeLinkedNode left;
        private TreeLinkedNode right;
        private TreeLinkedNode next;

        public TreeLinkedNode(int val) {
            this.val = val;
        }
    }

}
