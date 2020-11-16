/**
 * @projectName WrittenExam
 * @package com.wangjing.wriiten.exam
 * @className com.wangjing.wriiten.exam.BinaryTreeTraversal
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.wangjing.wriiten.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * BinaryTreeTraversal
 *
 * @description 二叉树遍历：根据二叉树的前序遍历和中序遍历的结果，
 * 重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * NLR：3、9、20、15、7
 * LNR：9、3、15、20、7
 * @thinking 三序遍历：
 * 先序遍历NLR：访问根节点的操作发生在遍历左右子树之前
 * 中序遍历LNR：访问根节点的操作发生在遍历左右子树之中
 * 后序遍历LRN：访问根节点的操作发生在遍历左右子树之后
 *
 *
 * 已知先序、中序：
 * 前序遍历第一个值为根节点的值，这个值将中须遍历分为两部分
 * 做部分位树的左子树的中序遍历，右部分位树的右子树的中序遍历
 * 后序遍历的最后一个元素是整个二叉树的根节点
 *
 * 已知中序、后续
 * 后序遍历的最后一个元素A是根节点
 * 中序中以该节点作为根节点切分左右子树
 *
 * @author wangjing
 * @date 2020/11/15 22:39
 * @version v1.0.0
 */
public class BinaryTreeTraversal {

    static class TreeNode {
        Integer data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(Integer data) {
            this.data = data;
        }
    }

    private static Map<Integer, Integer> indexForLnrOrders = new HashMap<>();

    private static TreeNode rebuildBinaryTree(int nlr[], int[] lnr) {
        for (int i = 0; i < lnr.length; i++) {
            indexForLnrOrders.put(lnr[i], i);
        }
        return rebuildBinaryTree(nlr, 0, nlr.length-1, 0);
    }

    private static TreeNode rebuildBinaryTree(int[] nlr, int preL, int preR,
        int lnr) {
        TreeNode root = new TreeNode(nlr[preL]);
        int lnrIndex = indexForLnrOrders.get(root.data);
        int leftTreeSize = lnrIndex - lnr;
        root.left = rebuildBinaryTree(nlr, preL+1, preL + leftTreeSize, lnr);
        root.right = rebuildBinaryTree(nlr, preL + leftTreeSize +1, preR, lnr + 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = rebuildBinaryTree(new int[] {3, 9, 20, 15}, new int[] {9, 3, 15, 20, 7});

    }
}
