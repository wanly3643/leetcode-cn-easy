/**
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
package tree;

import java.util.List;
import java.util.ArrayList;

public class SymmetricBST {
    private static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            boolean nonNull = true;
            List<TreeNode> p = new ArrayList<>();
            List<TreeNode> c = new ArrayList<>();
            p.set(0, root.left);
            p.set(1, root.right);
            TreeNode ll, lr, rl, rr;
            int ri;
            while(nonNull) {
                nonNull = false;
                for (int i = 0; i < p.size(); i ++) {
                    ri = p.size() - 1 - i;

                    if (p.get(i) != null) {
                        ll = p.get(i).left;
                        lr = p.get(i).right;

                        if (p.get(ri) != null && p.get(ri).val == p.get(i).val) {
                            nonNull = true;
                            rl = p.get(ri).left;
                            rr = p.get(ri).right;
                        } else {
                            return false;
                        }
                    } else {
                        ll = null;
                        lr = null;

                        if (p.get(ri) != null) {
                            return false;
                        } else {
                            rl = null;
                            rr = null;
                        }
                    }

                    c.set(i * 2, ll);
                    c.set(i * 2 + 1, lr);
                    c.set(ri * 2, rl);
                    c.set(ri * 2, rr);
                }

                // move
                List<TreeNode> tmp = p;
                p = c;
                c = tmp;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root;

        root = TreeNodeUtils.createBTree(new Integer[]{1});
        System.out.println(s.isSymmetric(root));

        root = TreeNodeUtils.createBTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(s.isSymmetric(root));

        root = TreeNodeUtils.createBTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println(s.isSymmetric(root));

        root = TreeNodeUtils.createBTree(new Integer[]{1, 2, 2, null, 3, 3, null});
        System.out.println(s.isSymmetric(root));

        root = TreeNodeUtils.createBTree(new Integer[]{1, 2, 2, 2, null, 2});
        System.out.println(s.isSymmetric(root));

        root = TreeNodeUtils.createBTree(new Integer[]{9,-42,-42,null,76,76,null,null,null,null,13,null,13,null,null});
        System.out.println(s.isSymmetric(root));
    }
}
