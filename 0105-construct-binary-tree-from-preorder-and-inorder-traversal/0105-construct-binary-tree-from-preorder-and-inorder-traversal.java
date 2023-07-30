/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preOrderIndex;
    HashMap<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode constructTree(int[] preOrder, int left, int right) {
        if (left > right) return null;
        
        int rootVal = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = constructTree(preOrder, left, inorderIndexMap.get(rootVal) - 1);
        root.right = constructTree(preOrder, inorderIndexMap.get(rootVal) + 1, right);
        return root;
    }
}