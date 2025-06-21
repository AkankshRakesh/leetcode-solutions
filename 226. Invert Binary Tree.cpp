class Solution {
public:
    TreeNode* switcheroo(TreeNode* node) {
        if (node == nullptr) return node;
        
        TreeNode* temp = switcheroo(node->left);
        node->left = switcheroo(node->right);
        node->right = temp;
        
        return node;
    }

    TreeNode* invertTree(TreeNode* root) {
        return switcheroo(root);
    }
};