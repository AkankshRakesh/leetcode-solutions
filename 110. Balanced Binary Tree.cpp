/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool ans = true;

    int trav(TreeNode* node) {
        if (node == nullptr) return 0;

        int left = trav(node->left);
        int right = trav(node->right);

        if (abs(left - right) > 1) {
            ans = false;
        }

        return 1 + max(left, right);
    }

    bool isBalanced(TreeNode* root) {
        trav(root);
        return ans;
    }
};
