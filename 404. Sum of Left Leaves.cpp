class Solution {
public:
    int traverse(TreeNode* node, bool isLeft) {
        if (node == nullptr) return 0;
        if (node->left == nullptr && node->right == nullptr) {
            if (isLeft) return node->val;
            return 0;
        }

        int ans = traverse(node->left, true) + traverse(node->right, false);
        return ans;
    }

    int sumOfLeftLeaves(TreeNode* root) {
        return traverse(root, false);
    }
};