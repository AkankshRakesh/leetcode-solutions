class Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int numOfNodes = preorder.length;

        int[] indexInPostOrder = new int[numOfNodes + 1];
        for (int index = 0; index < numOfNodes; index++) {
            indexInPostOrder[postorder[index]] = index;
        }

        return constructTree(0, numOfNodes - 1, 0, preorder, indexInPostOrder);
    }

    public TreeNode constructTree(
        int preStart,
        int preEnd,
        int postStart,
        int[] preorder,
        int[] indexInPostOrder
    ) {
        if (preStart > preEnd) return null;

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int leftRoot = preorder[preStart + 1];

        int numOfNodesInLeft = indexInPostOrder[leftRoot] - postStart + 1;

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = constructTree(
            preStart + 1,
            preStart + numOfNodesInLeft,
            postStart,
            preorder,
            indexInPostOrder
        );

        root.right = constructTree(
            preStart + numOfNodesInLeft + 1,
            preEnd,
            postStart + numOfNodesInLeft,
            preorder,
            indexInPostOrder
        );

        return root;
    }
}