package tree;

public class BinaryTreeMaxDepth {
    private static class Solution {
        public int maxDepth(TreeNode root) {
            return maxDepth(root, 0);
        }

        private int maxDepth(TreeNode node, int current) {
            if (node == null) {
                return current;
            } else {
                return Math.max(maxDepth(node.left, current + 1), maxDepth(node.right, current + 1));
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root;

        root = TreeNodeUtils.createBTree(new Integer[]{1});
        System.out.println(s.maxDepth(root));

        root = TreeNodeUtils.createBTree(new Integer[]{1, null, 2});
        System.out.println(s.maxDepth(root));

        root = TreeNodeUtils.createBTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(s.maxDepth(root));
    }
}
