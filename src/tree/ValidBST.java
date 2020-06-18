package tree;
import java.util.Stack;

public class ValidBST {
    private static class Solution {
        private static class MinMax {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return validate(root) != null;
        }

        public MinMax validate(TreeNode root) {
            if (root.left != null) {
                MinMax l = validate(root.left);
                if (l == null) {
                    return null;
                }

                if (root.right != null) {
                    MinMax r = validate(root.right);
                    if (r == null) {
                        return null;
                    }

                    if (r.min > root.val && l.max < root.val) {
                        r.min = l.min;
                        return r;
                    } else {
                        return null;
                    }
                } else {
                    if (l.max < root.val) {
                        l.max = root.val;
                        return l;
                    } else {
                        return null;
                    }
                }
            } else {
                if (root.right != null) {
                    MinMax r = validate(root.right);
                    if (r != null && r.min > root.val) {
                        r.min = root.val;
                        return r;
                    } else {
                        return null;
                    }
                } else {
                    MinMax m = new MinMax();
                    m.min = root.val;
                    m.max = root.val;
                    return m;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root;

        root = TreeNodeUtils.createBTree(new Integer[]{1});
        System.out.println(s.isValidBST(root));

        root = TreeNodeUtils.createBTree(new Integer[]{2, 1, 3});
        System.out.println(s.isValidBST(root));

        root = TreeNodeUtils.createBTree(new Integer[]{5,1,4,null,null,3,6});
        System.out.println(s.isValidBST(root));
    }
}
