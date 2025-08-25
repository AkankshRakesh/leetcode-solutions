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
    void largestTillNode(TreeNode* node, int maxVal, int &ans) {
        if (!node) return;

        if (node->val >= maxVal) {
            ans++;
            largestTillNode(node->left, node->val, ans);
            largestTillNode(node->right, node->val, ans);
        } else {
            largestTillNode(node->left, maxVal, ans);
            largestTillNode(node->right, maxVal, ans);
        }
    }

    int goodNodes(TreeNode* root) {
        int ans = 0;
        largestTillNode(root, root->val, ans);
        return ans;
    }
};
