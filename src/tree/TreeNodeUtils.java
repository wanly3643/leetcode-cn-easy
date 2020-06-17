package tree;

public class TreeNodeUtils {
    public static TreeNode createBTree(Integer[] list) {
        if (list == null || list.length <= 0 || list[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(list[0]);
        createChildren(root, list, 0);

        return root;
    }

    private static void createChildren(TreeNode parent, Integer[] list, int index) {
        if (index < list.length) {
            int lIndex = 2 * index + 1;
            if (lIndex < list.length && list[lIndex] != null) {
                TreeNode node = new TreeNode(list[lIndex]);
                parent.left = node;
                createChildren(node, list, lIndex);
            }
            int rIndex = 2 * index + 2;
            if (rIndex < list.length && list[rIndex] != null) {
                TreeNode node = new TreeNode(list[rIndex]);
                parent.left = node;
                createChildren(node, list, rIndex);
            }
        }
    }
}
