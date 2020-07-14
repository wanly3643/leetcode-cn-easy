/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
package tree;

import java.util.*;

public class LevelOrder {
    private static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Map<Integer, List<Integer>> cache = new HashMap<>();
            levelOrder(root, 0, cache);
            List<List<Integer>> ret = new LinkedList<>();
            for (int i = 0; i < cache.size(); i ++) {
                ret.add(cache.get(i));
            }

            return ret;
        }
        public void levelOrder(TreeNode root, int index, Map<Integer, List<Integer>> cache) {
            if (root != null) {
                List<Integer> list = cache.computeIfAbsent(index, k -> new LinkedList<>());
                list.add(root.val);

                // Left and right
                levelOrder(root.left, index + 1, cache);
                levelOrder(root.right, index + 1, cache);
            }
        }
    }

    private static void printList(List<List<Integer>> ret) {
        System.out.println("[");

        for (List<Integer> list : ret) {
            System.out.print("  [");
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root;

        root = TreeNodeUtils.createBTree(new Integer[]{3,9,20,null,null,15,7});
        printList(s.levelOrder(root));
    }
}
